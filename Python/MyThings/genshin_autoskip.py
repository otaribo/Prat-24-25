import os
from random import randint, uniform
from threading import Thread
from typing import Union
from time import sleep
from win32api import GetSystemMetrics

import pyautogui
from pynput.keyboard import Key, KeyCode, Listener
from dotenv import find_dotenv, load_dotenv, set_key

# Initial setup
os.system('cls')
load_dotenv()
print('Welcome to Genshin Impact Dialogue Skipper\n')

SCREEN_WIDTH = None
SCREEN_HEIGHT = None

# Check if either screen dimension is missing from .env
if os.environ.get('WIDTH', '') == '' or os.environ.get('HEIGHT', '') == '':
    # Detect and set screen dimensions
    SCREEN_WIDTH = GetSystemMetrics(0)
    SCREEN_HEIGHT = GetSystemMetrics(1)

    print(f'Detected Resolution: {SCREEN_WIDTH}x{SCREEN_HEIGHT}')
    print('Is the resolution correct? (y/n)')
    response = input().lower()

    if response.startswith('n'):
        print('Enter resolution width: ', end='')
        SCREEN_WIDTH = int(input())
        print('Enter resolution height: ', end='')
        SCREEN_HEIGHT = int(input())
        print('\nNew resolution set to ' + str(SCREEN_WIDTH) + 'x' + str(SCREEN_HEIGHT) + '\n')

    # Write changes to .env file
    dotenv_file = find_dotenv()
    set_key(dotenv_file, "WIDTH", str(SCREEN_WIDTH), quote_mode="never")
    set_key(dotenv_file, "HEIGHT", str(SCREEN_HEIGHT), quote_mode="never")
else:
    SCREEN_WIDTH = int(os.getenv('WIDTH'))
    SCREEN_HEIGHT = int(os.getenv('HEIGHT'))

def width_adjust(x: int) -> int:
    return int(x / 1920 * SCREEN_WIDTH)

def height_adjust(y: int) -> int:
    return int(y / 1080 * SCREEN_HEIGHT)

# Pixel coordinates for white part of the autoplay button
PLAYING_ICON_X = width_adjust(84)
PLAYING_ICON_Y = height_adjust(46)

# Pixel coordinates for white part of the speech bubble in bottom dialogue option
DIALOGUE_ICON_X = width_adjust(1301)
DIALOGUE_ICON_LOWER_Y = height_adjust(808)
DIALOGUE_ICON_HIGHER_Y = height_adjust(790)

# Pixel coordinates near middle of the screen known to be white while the game is loading
LOADING_SCREEN_X = width_adjust(1200)
LOADING_SCREEN_Y = height_adjust(700)

def random_interval() -> float:
    return uniform(0.18, 0.2) if randint(1, 6) == 6 else uniform(0.12, 0.18)

def on_press(key: Union[Key, KeyCode, None]) -> None:
    key_pressed = str(key)

    if key_pressed == 'Key.f8':
        main.status = 'run'
        print('RUNNING')
    elif key_pressed == 'Key.f9':
        main.status = 'pause'
        print('PAUSED')
    elif key_pressed == 'Key.f12':
        main.status = 'exit'
        exit()

def main() -> None:
    def is_dialogue_playing():
        return pyautogui.pixel(PLAYING_ICON_X, PLAYING_ICON_Y) == (236, 229, 216)

    def is_dialogue_option_available():
        if pyautogui.pixel(LOADING_SCREEN_X, LOADING_SCREEN_Y) == (255, 255, 255):
            return False
        return (
            pyautogui.pixel(DIALOGUE_ICON_X, DIALOGUE_ICON_LOWER_Y) == (255, 255, 255) or
            pyautogui.pixel(DIALOGUE_ICON_X, DIALOGUE_ICON_HIGHER_Y) == (255, 255, 255)
        )

    main.status = 'pause'

    print('-------------\n'
          'F8 to start\n'
          'F9 to stop\n'
          'F12 to quit\n'
          '-------------')

    while True:
        while main.status == 'pause':
            sleep(0.5)

        if main.status == 'exit':
            print('Main program closing')
            break

        # Solo dependemos del estado visual
        if is_dialogue_playing() or is_dialogue_option_available():
            pyautogui.press('f')
            sleep(random_interval())

if __name__ == "__main__":
    Thread(target=main).start()

    with Listener(on_press=on_press) as listener:
        listener.join()