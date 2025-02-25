import pygame
import random
import sys
import os
from PIL import Image

# ========================
# Configuració inicial
# ========================
WIDTH = 1920
HEIGHT = 1080
FPS = 144

# Colors (RGB)
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED   = (255, 0, 0)
BLUE  = (0, 0, 255)
GREEN = (0,255,0)

#============================================
# Paths
#============================================
file_path = os.path.dirname(os.path.abspath(__file__))
sprites_path = os.path.join(file_path,"sprites")
# Enemigos
enemigo = os.path.join(sprites_path,"enemies")

# Personaje
ruta_CharacterSprites = os.path.join(sprites_path,"character")
player_sprite_path = os.path.join(ruta_CharacterSprites,"player.png")
player_sprite = Image.open(player_sprite_path)
 
disparo_sprite = os.path.join(ruta_CharacterSprites,"Knife.png")
 
# Wallpapers
fondos_path = os.path.join(file_path,"Fondos")
menuWallpaper = os.path.join(fondos_path,"analog-horror.png")
juegoWalpaper = os.path.join(fondos_path,"Fondo_juego.webp")
menuPausaWallpaper = os.path.join(fondos_path,"menu_animation")
FazbearPizzeriaWalking = os.path.join(fondos_path,"fazbear_pizzeria_walking")

# Music

AudioFiles = os.path.join(file_path,"Audio_Files")
PauseMenuSoundtrack = os.path.join(AudioFiles,"PauseMenu.mp3")
GameSountrack = os.path.join(AudioFiles,"GameSoundtrack.mp3")
StartMenuMusic = os.path.join(AudioFiles, "StartMenuMusic.mp3")
#============================================


# Inicialitzar Pygame i la finestra
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Joc python")
clock = pygame.time.Clock()
font = pygame.font.SysFont("Arial", 24)
TittleFont = pygame.font.SysFont("Arial", 150)

# ========================
# Variables Globals del Joc
# ========================
score = 0
difficulty_level = 1
last_difficulty_update_time = pygame.time.get_ticks()
spawn_interval = 1500
ADD_OBSTACLE = pygame.USEREVENT + 1


# ========================
# Funcions Auxiliars
# ========================

def draw_text(surface, text, font, color, x, y):
    """Dibuixa un text a la pantalla."""
    text_obj = font.render(text, True, color)
    surface.blit(text_obj, (x, y))

# ========================
# Classes del Joc
# ========================

class Player(pygame.sprite.Sprite):
    """Classe per al jugador."""
    def __init__(self):
        super().__init__()
        size = 40
        self.player_height, self.player_width = player_sprite.size
        self.image = pygame.image.load(player_sprite_path)
        self.image = pygame.transform.scale(self.image, ((size/self.player_width*500), (size/self.player_height*500)))
        self.rect = self.image.get_rect()
        self.rect.center = (100, HEIGHT // 2)
        self.speed = 5
        self.vida = 10
        self.UltimoGolpe = 0

    def update(self):
        """Actualitza la posició del jugador segons les tecles premudes."""
        keys = pygame.key.get_pressed()
        if keys[pygame.K_UP]:
            self.rect.y -= self.speed
        if keys[pygame.K_DOWN]:
            self.rect.y += self.speed
        if keys[pygame.K_LEFT]:
            self.rect.x -= self.speed
        if keys[pygame.K_RIGHT]:
            self.rect.x += self.speed

        # Evitar que el jugador surti de la pantalla
        if self.rect.left < 0:
            self.rect.left = 0
        if self.rect.right > WIDTH:
            self.rect.right = WIDTH
        if self.rect.top < 0:
            self.rect.top = 0
        if self.rect.bottom > HEIGHT:
            self.rect.bottom = HEIGHT
        

class Enemigo(pygame.sprite.Sprite):
    """Classe per als obstacles."""
    def __init__(self):
        super().__init__()
        self.size = 40
        path = os.path.join(enemigo,"Donkey.png")
        image = Image.open(path)
        self.photo_height, self.photo_width = image.size
        self.image = pygame.image.load(path)
        self.image = pygame.transform.scale(self.image, ((self.size/self.photo_width*500), (self.size/self.photo_height*500)))
        self.rect = self.image.get_rect()
        self.rect.x = (WIDTH + self.photo_width + 15)
        self.rect.y = random.randint(0 + self.photo_height, HEIGHT - self.photo_height)
        self.speed = random.randint(3 + difficulty_level, 7 + difficulty_level)
        self.mask = pygame.mask.from_surface(self.image)

    def update(self):
        global score
        self.rect.x -= self.speed
        if self.rect.right < 0:
            score += 1
            self.kill()

class Enemigo_Tipo_1(Enemigo):
    def __init__(self):
        super().__init__()
        self.size = 70
        path = os.path.join(enemigo,"other.png")
        self.image = pygame.image.load(path)
        self.image = pygame.transform.scale(self.image, (((self.size/self.photo_width*500), (self.size/self.photo_height*500))))
        self.mask = pygame.mask.from_surface(self.image)
        self.speed_x = 10
        self.speed_y = 2
    
    def update(self):
        global score

        self.rect.x -= self.speed_x

        if player.rect.y > self.rect.y:
            self.rect.y += self.speed_y
        if player.rect.y < self.rect.y: 
            self.rect.y -= self.speed_y

        if self.rect.right < 0:
            score += 1
            self.kill()
        
class Enemigo_Tipo_2(Enemigo):
    def __init__(self):
        super().__init__()
        self.size = 100
        path = os.path.join(enemigo,"Donkey.png")
        self.image = pygame.image.load(path)
        self.image = pygame.transform.scale(self.image, (((self.size/self.photo_width*500), (self.size/self.photo_height*500))))
        self.mask = pygame.mask.from_surface(self.image)

class Enemigo_Garfield(Enemigo):
    def __init__(self):
        super().__init__()
        self.size = 70
        self.path = os.path.join(enemigo,"Garfield_Cursed")
        self.frames =[f for f in os.listdir(self.path) if f.lower().endswith(('.png', '.jpg', '.jpeg', '.gif', '.bmp'))]
        self.Garfield_Frame_Index = 0
        self.Garfield_Frame_Index_Max = len(self.frames)
        self.image = pygame.image.load(os.path.join(self.path, self.frames[0]))
        self.image = pygame.transform.scale(self.image, (((self.size/self.photo_width*500), (self.size/self.photo_height*500))))
        self.speed = 3
        
    def update(self):
        global score
        self.image = pygame.image.load(os.path.join(self.path, self.frames[self.Garfield_Frame_Index]))
        self.image = pygame.transform.flip(self.image,1,0)
        self.mask = pygame.mask.from_surface(self.image)
        if(FPS%2==0):
            self.Garfield_Frame_Index += 1
        if (self.Garfield_Frame_Index >= self.Garfield_Frame_Index_Max):
            self.Garfield_Frame_Index = 0
        self.rect.x -= self.speed
        if self.rect.right < 0:
            score += 1
            self.kill()

class Disparo(pygame.sprite.Sprite):
    def __init__(self,x,y):
        super().__init__()
        self.image = pygame.image.load(disparo_sprite)
        self.image = pygame.transform.scale(self.image,((160/2),(160/2)))
        self.image = pygame.transform.rotate(self.image,-15)
        self.rect = self.image.get_rect()
        self.rect.y = y
        self.rect.x = x
        self.speed = 10
        
    def update(self):
            self.rect.x += self.speed
            if self.rect.x >= WIDTH:
                self.kill()

#================ #
# Clases Interfaz #
#================ #

class Button:
    def __init__(self, x, y, width, height, text, font, color, hover_color):
        self.rect = pygame.Rect(x, y, width, height)
        self.text = text
        self.font = font
        self.color = color
        self.hover_color = hover_color
        self.hovered = False

    def draw(self, surface):
        color = self.hover_color if self.hovered else self.color
        pygame.draw.rect(surface, color, self.rect, border_radius=10) 
        text_surface = self.font.render(self.text, True, WHITE)
        text_rect = text_surface.get_rect(center=self.rect.center)
        surface.blit(text_surface, text_rect)

    def check_hover(self, mouse_pos):
        self.hovered = self.rect.collidepoint(mouse_pos)

    def is_clicked(self, mouse_pressed):
        return (self.hovered and mouse_pressed[0])    
 
class Fazbear(pygame.sprite.Sprite):
    def __init__(self, y, tamaño):
        super().__init__()
        self.heigth = (528/tamaño*200)
        self.width = (1452/tamaño*200)
        self.rect = pygame.Rect(-1452, y, (self.width/2), (self.heigth/2))
        self.rect.x = -1452
        self.rect.y = y
        self.fazbear = [f for f in os.listdir(FazbearPizzeriaWalking) if f.lower().endswith(('.png', '.jpg', '.jpeg', '.gif', '.bmp'))]
        self.fazbear_index = 0
        self.image = pygame.image.load(os.path.join(FazbearPizzeriaWalking,self.fazbear[0]))
        self.direccion = 0
    
    def update(self):
        if (self.direccion == 0):
            self.rect.x += 10
        else:
            self.rect.x -= 10

        if (self.rect.x >= (WIDTH+self.width)):
            self.direccion = 1
        
        if (self.rect.x <= (-(self.width*2))):
            self.direccion = 0

        if (self.fazbear_index == 0):
            self.image = pygame.image.load(os.path.join(FazbearPizzeriaWalking,self.fazbear[0]))
            self.image = pygame.transform.flip(self.image,0,0) if self.direccion == 0 else pygame.transform.flip(self.image,1,0)
            self.fazbear_index += 1
        elif(self.fazbear_index == 6):
            self.image = pygame.image.load(os.path.join(FazbearPizzeriaWalking,self.fazbear[1]))
            self.image = pygame.transform.flip(self.image,0,0) if self.direccion == 0 else pygame.transform.flip(self.image,1,0)
            self.fazbear_index += 1
        if(self.fazbear_index == 12):
            self.fazbear_index = 0
        else:
            self.fazbear_index += 1
            
    def draw(self, surface):
        surface.blit(self.image, self.rect)

def draw_health_bar(surface, x, y, current_health, max_health):
    """Dibuja una barra de vida en la pantalla."""
    bar_width = 300  # Ancho de la barra de vida
    bar_height = 35   # Alto de la barra de vida
    fill = (current_health / max_health) * bar_width  # Longitud de la barra de vida actual

    # Dibujar el fondo de la barra de vida (vacía)
    pygame.draw.rect(surface, RED, (x, y, bar_width, bar_height))

    # Dibujar la barra de vida actual (relleno)
    pygame.draw.rect(surface, GREEN, (x, y, fill, bar_height))
# ================================ #
# Funció per reinicialitzar el Joc #
# ================================ #

def inicialitzacio():
    """Reinicialitza totes les variables i grups per començar una nova partida."""
    global score, difficulty_level, lives, last_difficulty_update_time, spawn_interval, all_sprites, obstacles, player, disparos
    score = 0
    difficulty_level = 1
    lives = 3
    last_difficulty_update_time = pygame.time.get_ticks()
    spawn_interval = 1500
    pygame.time.set_timer(ADD_OBSTACLE, spawn_interval)
    all_sprites = pygame.sprite.Group()
    obstacles = pygame.sprite.Group()
    player = Player()
    disparos = pygame.sprite.Group()
    all_sprites.add(player)

# ==================================== #
# Funció per mostrar el menú principal #
# ==================================== #

def inici():
    """Mostra la pantalla de menú d'inici i espera que l'usuari premi alguna tecla per començar."""
    inicialitzacio()
    pygame.mixer.music.load(StartMenuMusic)
    pygame.mixer.music.play(-1)
    pygame.mixer.music.set_volume(150.0)
    menu = pygame.image.load(menuWallpaper)
    menu = pygame.transform.scale(menu, (WIDTH, HEIGHT))
    screen.blit(menu,(0,0))
    button_font = pygame.font.SysFont("Arial", 36)
    Play_button = Button((WIDTH / 2 - 650), (HEIGHT / 2 - 150), 300, 75, "Jugar", button_font, ((120),(120),(120)), RED)
    Quit_button = Button((WIDTH / 2 - 650), (HEIGHT / 2), 300, 75, "Salir", button_font, ((120),(120),(120)), RED)
    waiting = True
    while waiting:
        clock.tick(FPS)
        draw_text(screen, "Python VHS Game", TittleFont, WHITE,(WIDTH / 2 - 700),(HEIGHT / 2 - 400))
        mouse_pos = pygame.mouse.get_pos()
        mouse_pressed = [pygame.mouse.get_pressed()]

        Play_button.check_hover(mouse_pos)
        Quit_button.check_hover(mouse_pos)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.mixer.music.stop()  # Detener el audio antes de salir
                pygame.quit()
                sys.exit()

            if event.type == pygame.MOUSEBUTTONDOWN:
                if Play_button.is_clicked(mouse_pressed):  # Reanudar juego
                    Waiting = False
                    game_loop()
                    
                elif Quit_button.is_clicked(mouse_pressed):  # Salir del juego
                    pygame.mixer.music.stop()  # Detener el audio antes de salir
                    pygame.quit()
                    sys.exit()

        Play_button.draw(screen)
        Quit_button.draw(screen)
        pygame.display.flip()
    game_loop()

# ============================== #
# Funció per executar la partida #
# ============================== #

def game_loop():
    pygame.mixer.music.load(GameSountrack)
    pygame.mixer.music.play(-1)
    pygame.mixer.music.set_volume(0.2)
    """Executa el bucle principal de la partida."""
    global difficulty_level, last_difficulty_update_time, spawn_interval, lives, running, score
    menu = pygame.image.load(juegoWalpaper)
    menu = pygame.transform.scale(menu, (WIDTH, HEIGHT))
    game_state = "playing"
    running = True
    while running and game_state == "playing":
        clock.tick(FPS)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == ADD_OBSTACLE:
                enemy_class = random.choice([Enemigo_Tipo_1, Enemigo_Tipo_2, Enemigo_Garfield])  # Elegir la clase, no una instancia
                obstacle = enemy_class()  # Crear una nueva instancia
                print("Enemigo generado:", type(obstacle).__name__)
                all_sprites.add(obstacle)
                obstacles.add(obstacle)
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                disparo = Disparo(player.rect.x,player.rect.y)
                all_sprites.add(disparo)
                disparos.add(disparo)
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_ESCAPE:
                pygame.mixer.music.stop()
                show_pause_menu()

        # Incrementar la dificultat cada 15 segons
        current_time = pygame.time.get_ticks()
        if current_time - last_difficulty_update_time >= 15000:
            difficulty_level += 1
            last_difficulty_update_time = current_time
            spawn_interval = max(500, 1500 - difficulty_level * 100)
            pygame.time.set_timer(ADD_OBSTACLE, spawn_interval)
        # Actualitzar els sprites
        all_sprites.update()
        # Comprovar col·lisions
        for disparo in disparos:
            enemigos_colisionados = pygame.sprite.spritecollide(disparo, obstacles, False, pygame.sprite.collide_mask)
            if enemigos_colisionados:
                for enemigo in enemigos_colisionados:
                    enemigo.kill()
                    disparo.kill() 
                    score += 1
# Comprobar colisiones entre el jugador y los enemigos
        if pygame.sprite.spritecollideany(player, obstacles, pygame.sprite.collide_mask):
            if (current_time - player.UltimoGolpe) > 500: 
                player.vida -= 1
                if player.vida >= 1:
                    player.UltimoGolpe = pygame.time.get_ticks()
                else:
                    pygame.mixer.music.stop()
                    game_state = "game_over"
        
        # Dibuixar la escena
        screen.blit(menu,(0,0))
        all_sprites.draw(screen)

        draw_health_bar(screen, 210, 130, player.vida, 10)

        score_text = font.render("Puntuació: " + str(score), True, WHITE)
        difficulty_text = font.render("Dificultat: " + str(difficulty_level), True, WHITE)
        screen.blit(score_text, (10, 10))
        screen.blit(difficulty_text, (10, 40))
        pygame.display.flip()
    show_game_over(score)

# =========================================== #
# Funció per mostrar la pantalla de Game Over #
# =========================================== #

def show_game_over(final_score):
    """Mostra la pantalla de Game Over amb la puntuació final i espera per reiniciar."""
    waiting = True
    while waiting:
        clock.tick(FPS)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                waiting = False
        screen.fill(WHITE)
        draw_text(screen, "Game Over!", font, RED, 350, 200)
        draw_text(screen, "Puntuació Final: " + str(final_score), font, BLACK, 320, 250)
        draw_text(screen, "Prem qualsevol tecla per reiniciar", font, BLACK, 250, 300)
        pygame.display.flip()
        player.kill()
        inici()

# ======================== #
# Funcio del Menu de pausa #
# ======================== #
def show_pause_menu():
   
    frames = [f for f in os.listdir(menuPausaWallpaper) if f.lower().endswith(('.png', '.jpg', '.jpeg', '.gif', '.bmp'))]
    
    paused = True
    frame_index = 0
    
    pygame.mixer.music.load(PauseMenuSoundtrack)
    pygame.mixer.music.play(-1)
    pygame.mixer.music.set_volume(1.0)

    button_font = pygame.font.SysFont("Arial", 36)
    resume_button = Button((WIDTH / 2 - 100), (HEIGHT / 2 - 50), 200, 50, "Reanudar", button_font, ((120),(120),(120)), RED)
    quit_button = Button((WIDTH / 2 - 100), (HEIGHT / 2 + 50), 200, 50, "Salir", button_font, ((120),(120),(120)), RED)
    fazbear=Fazbear(400, 300)
    

    
    while paused:
        clock.tick(30)  # Control de FPS

        mouse_pos = pygame.mouse.get_pos()
        mouse_pressed = [pygame.mouse.get_pressed()]

        resume_button.check_hover(mouse_pos)
        quit_button.check_hover(mouse_pos)
        fazbear.update()
        
        if frames:  # Solo intenta cargar el frame si hay frames disponibles
            # Cargar el frame actual
            frame = pygame.image.load(os.path.join(menuPausaWallpaper, frames[frame_index]))
            frame = pygame.transform.scale(frame, (WIDTH, HEIGHT))

            screen.blit(frame, (0, 0))  # Dibujar el frame en la pantalla
        # Cambiar de frame (hace un loop infinito)
        if frames:  # Solo incrementa el índice si hay frames disponibles
            frame_index = (frame_index + 1) % len(frames)

        # Manejo de eventos
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.mixer.music.stop()  # Detener el audio antes de salir
                pygame.quit()
                sys.exit()

            if event.type == pygame.MOUSEBUTTONDOWN:
                if resume_button.is_clicked(mouse_pressed):  # Reanudar juego
                    paused = False
                    pygame.mixer.music.stop()
                    print("resume button clicked")
                    game_loop()
                    
                elif quit_button.is_clicked(mouse_pressed):  # Salir del juego
                    pygame.mixer.music.stop()
                    print("quit button clicked")
                    inici()

        resume_button.draw(screen)
        quit_button.draw(screen)
        fazbear.draw(screen)
        
        pygame.display.flip()


    
inici()