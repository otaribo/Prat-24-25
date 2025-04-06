import random
class Personaje:
    def __init__(self, nombre, vida, ataque, defensa):
        self.nombre = nombre
        self.vida = vida
        self.ataque = ataque
        self.defensa = defensa
    
    def setNombre(self, nombre):
        self.nombre = nombre  
    def getNombre(self):
        return self.nombre
    def setVida(self, vida):
        self.vida = vida   
    def getVida(self):
        return self.vida   
    def setAtaque(self, ataque):
        self.ataque = ataque  
    def getAtaque(self):
        return self.ataque
    def setDefensa(self, defensa):
        self.defensa = defensa
    def getDefensa(self):
        return self.defensa
    
    def atacar(self, enemigo):
        daño = self.getAtaque - enemigo.getDefensa
        enemigo.setVida(enemigo.getVida() - daño)

class Mapa:
    def __init__(self, nombre, tamaño):
        self.nombre = nombre
        self.tamaño = tamaño
        self.mapa = [['#' for _ in range(tamaño)] for _ in range(tamaño)]
        self.jugador_pos = (1, 1)  # Posición inicial del jugador

    def getTamaño(self):
        return self.tamaño

    def generar_laberinto_base(self):
        # Aseguramos bordes como paredes
        for i in range(self.tamaño):
            for j in range(self.tamaño):
                if i == 0 or i == self.tamaño-1 or j == 0 or j == self.tamaño-1:
                    self.mapa[i][j] = '#'

        # Algoritmo de generación mejorado
        stack = [(1, 1)]
        self.mapa[1][1] = '.'
        direcciones = [(2, 0), (-2, 0), (0, 2), (0, -2)]

        while stack:
            x, y = stack[-1]
            random.shuffle(direcciones)
            movido = False

            for dx, dy in direcciones:
                nx, ny = x + dx, y + dy
                # Respetamos los bordes
                if 0 < nx < self.tamaño-1 and 0 < ny < self.tamaño-1:
                    if self.mapa[nx][ny] == '#':
                        # Romper pared intermedia
                        self.mapa[x + dx//2][y + dy//2] = '.'  
                        self.mapa[nx][ny] = '.'
                        stack.append((nx, ny))
                        movido = True
                        break
            
            if not movido:
                stack.pop()

    def eliminar_callejones(self, iteraciones=2):
        # Elimina callejones pero respeta posición del jugador
        for _ in range(iteraciones):
            for x in range(1, self.tamaño-1):
                for y in range(1, self.tamaño-1):
                    if (x, y) == self.jugador_pos:
                        continue  # Saltamos posición del jugador
                    
                    if self.mapa[x][y] == '.':
                        vecinos = 0
                        for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
                            if self.mapa[x+dx][y+dy] == '.':
                                vecinos += 1
                        
                        if vecinos == 1:  # Callejón sin salida
                            # Convertimos a pared con 50% probabilidad
                            if random.random() < 0.5:
                                self.mapa[x][y] = '#'

    def rellenarMapa(self, densidad_paredes=0.25):
        self.generar_laberinto_base()
        self.eliminar_callejones()
        
        # Aseguramos bordes nuevamente por si hubo modificaciones
        for i in range(self.tamaño):
            for j in range(self.tamaño):
                if i == 0 or i == self.tamaño-1 or j == 0 or j == self.tamaño-1:
                    self.mapa[i][j] = '#'

        # Colocamos al jugador en una posición válida
        self.jugador_pos = (1, 1)
        while self.mapa[self.jugador_pos[0]][self.jugador_pos[1]] != '.':
            self.jugador_pos = (random.randint(1, self.tamaño-2), 
                              random.randint(1, self.tamaño-2))

    def mostrarMapa(self):
        for i, fila in enumerate(self.mapa):
            for j, celda in enumerate(fila):
                if (i, j) == self.jugador_pos:
                    print('P', end=' ')
                else:
                    print(celda, end=' ')
            print()

    # Método adicional para mover al jugador (ejemplo)
    def mover_jugador(self, direccion):
        x, y = self.jugador_pos
        dx, dy = 0, 0
        if direccion == 'arriba': dx = -1
        elif direccion == 'abajo': dx = 1
        elif direccion == 'izquierda': dy = -1
        elif direccion == 'derecha': dy = 1
        
        nueva_x = x + dx
        nueva_y = y + dy
        
        if 0 <= nueva_x < self.tamaño and 0 <= nueva_y < self.tamaño:
            if self.mapa[nueva_x][nueva_y] == '.':
                self.jugador_pos = (nueva_x, nueva_y)


Personaje1 = Personaje("Guerrero", 100, 20, 10)
mapa1 = Mapa("Mapa1", 20)
mapa1.rellenarMapa()
mapa1.mostrarMapa()
