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
FPS = 60

# Colors (RGB)
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED   = (255, 0, 0)
BLUE  = (0, 0, 255)

#Sprites & Wallpapers
#============================================
#Enemigos
enemigo = r"C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\Videojoc\\sprites\\enemies"

#Personaje
ruta_CharacterSprites = r"C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\Videojoc\\sprites\\character"
player_sprite = os.path.join(ruta_CharacterSprites,"player.png")
player = Image.open(player_sprite)
 
disparo_sprite = os.path.join(ruta_CharacterSprites,"disparo.png")
 
#Wallpapers

menuWallpaper = r"C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\Videojoc\\Fondos\\analog-horror.png"
juegoWalpaper = r"C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\Videojoc\\Fondos\\Fondo_juego.webp"
menuPausaWallpaper = r"C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\Videojoc\\Fondos\\menu_animacion"
#============================================


# Inicialitzar Pygame i la finestra
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Joc python")
clock = pygame.time.Clock()
font = pygame.font.SysFont("Arial", 24)

# ========================
# Variables Globals del Joc
# ========================
score = 0
difficulty_level = 1
lives = 3
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
        photo_height, photo_width = player.size
        self.image = pygame.image.load(player_sprite)
        self.image = pygame.transform.scale(self.image, ((size/photo_width*500), (size/photo_height*500)))
        self.rect = self.image.get_rect()
        self.rect.center = (100, HEIGHT // 2)
        self.speed = 5

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

class Obstacle(pygame.sprite.Sprite):
    """Classe per als obstacles."""
    def __init__(self):
        super().__init__()
        # Crear un obstacle amb dimensions aleatòries
        size = random.randint(20, 100)
        listaSprites = [f for f in os.listdir(enemigo) if f.lower().endswith(('.png', '.jpg', '.jpeg', '.gif', '.bmp'))]
        randompick = random.choice(listaSprites)
        path = os.path.join(enemigo,randompick)
        image = Image.open(path)
        photo_height, photo_width = image.size
        self.image = pygame.image.load(path)
        self.image = pygame.transform.scale(self.image, ((size/photo_width*500), (size/photo_height*500)))
        self.rect = self.image.get_rect()
        # Posició inicial: fora de la pantalla per la dreta
        self.rect.x = WIDTH + random.randint(10, 100)
        self.rect.y = random.randint(0, HEIGHT - size)
        # La velocitat s'incrementa amb la dificultat
        self.speed = random.randint(3 + difficulty_level, 7 + difficulty_level)

    def update(self):
        """Actualitza la posició de l'obstacle movent-lo cap a l'esquerra.
           Quan surt completament de la pantalla, s'incrementa la puntuació i s'elimina."""
        global score
        self.rect.x -= self.speed
        if self.rect.right < 0:
            score += 1
            self.kill()

class Disparo(pygame.sprite.Sprite):
    def __init__(self,x,y):
        super().__init__()
        self.image = pygame.image.load(disparo_sprite)
        self.image = pygame.transform.scale(self.image,((160/2),(160/2)))
        self.image = pygame.transform.rotate(self.image,-45)
        self.rect = self.image.get_rect()
        self.rect.y = y
        self.rect.x = x
        self.speed = 10

    def update(self):
            self.rect.x += self.speed
            if self.rect.x >= WIDTH:
                self.kill()
            
            


# ========================
# Funció per reinicialitzar el Joc
# ========================

def new_game():
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

# ========================
# Funció per mostrar el menú principal
# ========================

def show_menu():
    """Mostra la pantalla de menú d'inici i espera que l'usuari premi alguna tecla per començar."""
    menu = pygame.image.load(menuWallpaper)
    menu = pygame.transform.scale(menu, (WIDTH, HEIGHT))
    waiting = True
    while waiting:
        clock.tick(FPS)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                waiting = False
        screen.blit(menu,(0,0))
        draw_text(screen, "Joc Extensible", font, BLACK, 300, 200)
        draw_text(screen, "Prem qualsevol tecla per començar", font, BLACK, 220, 250)
        pygame.display.flip()

# ========================
# Funció per executar la partida
# ========================

def game_loop():
    """Executa el bucle principal de la partida."""
    global difficulty_level, last_difficulty_update_time, spawn_interval, lives
    new_game()
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
                obstacle = Obstacle()
                all_sprites.add(obstacle)
                obstacles.add(obstacle)
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                disparo = Disparo(player.rect.x,player.rect.y)
                all_sprites.add(disparo)
                disparos.add(disparo)
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_ESCAPE:
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
        if pygame.sprite.spritecollideany(player, obstacles):
            lives -= 1
            if lives > 0:
                # Reinicialitzar la posició del jugador i esborrar els obstacles
                player.rect.center = (100, HEIGHT // 2)
                for obs in obstacles:
                    obs.kill()
            else:
                game_state = "game_over"

        collisions = pygame.sprite.groupcollide(disparos, obstacles, True, True)
        if collisions:
            obstacle.kill()
            disparo.kill()
        
        # Dibuixar la escena
        screen.blit(menu,(0,0))
        all_sprites.draw(screen)
        score_text = font.render("Puntuació: " + str(score), True, BLACK)
        difficulty_text = font.render("Dificultat: " + str(difficulty_level), True, BLACK)
        lives_text = font.render("Vides: " + str(lives), True, BLACK)
        screen.blit(score_text, (10, 10))
        screen.blit(difficulty_text, (10, 40))
        screen.blit(lives_text, (10, 70))
        pygame.display.flip()
    return score

# ========================
# Funció per mostrar la pantalla de Game Over
# ========================

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

#=========================
# Funcio del Menu de pausa
#=========================
def show_pause_menu():
    """Muestra el menú de pausa con un fondo animado usando imágenes como frames."""
    frames = [f for f in os.listdir(menuPausaWallpaper)]
    paused = True
    frame_index = 0

    while paused:
        clock.tick(30)  # Control de FPS

        # Cargar el frame actual
        frame = pygame.image.load(os.path.join(menuPausaWallpaper,frames[frame_index]))
        frame = pygame.transform.scale(frame, (WIDTH, HEIGHT))
        screen.blit(frame, (0, 0))  # Dibujar el frame en la pantalla

        # Mostrar texto del menú
        draw_text(screen, "PAUSA", font, WHITE, WIDTH//2 - 40, HEIGHT//3)
        draw_text(screen, "Presiona [P] para continuar", font, WHITE, WIDTH//2 - 120, HEIGHT//2)
        draw_text(screen, "Presiona [Q] para salir", font, WHITE, WIDTH//2 - 100, HEIGHT//2 + 40)

        pygame.display.flip()

        # Cambiar de frame (hace un loop infinito)
        frame_index = (frame_index + 1) % len(frames)

        # Manejo de eventos
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_p:  # Reanudar juego
                    paused = False
                elif event.key == pygame.K_q:  # Salir del juego
                    pygame.quit()
                    sys.exit()



# ========================
# Bucle principal del programa
# ========================

while True:
    show_menu()                   # Mostrar menú d'inici
    final_score = game_loop()       # Executar la partida
    show_game_over(final_score)     # Mostrar pantalla de Game Over i esperar reinici