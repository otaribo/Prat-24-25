class Partida():
    def __init__(self):
        self.NumeroTurno = 0
        self.Player = None
        self.CPU = None 

    def creacioPartida(self):
        Seleccio = int(input("Que personaje quieres utilizar: \n[1]Guerrero\n[2]Escudero\nSeleccio: "))
        if Seleccio == 1:
            self.Player = Guerrero("Player",1000,10,15,7)
            self.CPU = Escudero("CPU", 1000,5,12,9)
        elif Seleccio == 2:
            self.CPU = Guerrero("Player",1000,10,15,7)
            self.Player = Escudero("CPU", 1000,5,12,9)
        self.Inicar()

    def Iniciar(self):
        self.NumeroTurno = 0
        while self.Player.vida > 0 and self.CPU.vida > 0:
            self.Turno()

    def Turno(self):
        self.Acciones(self.Player, self.AccionJugador)
        self.Acciones(self.CPU, self.AccionCPU)
        self.NumeroTurno += 1

    def Acciones(self, Accion):
        if Accion ==1:
            print(f"{self.nombre} ha atacado causando {self.daño} puntos de daño")
            self.atacar
        elif Accion == 2:
            self.defender
        elif Accion == 3:
            print(f"{self.nombre} se ha curado {self.curar} puntos de salud")
            self.curarse
    def AccionJugador():
        while(Accion != 1 or Accion != 2 or Accion != 3):
            Accion = int(input("[1] Atacar \n[2] Defender \n[3] Curarse"))
        return Accion
    def AccionCPU(self,Player):
        if self.vida <= (self.vidaMax/100*30) and Player.vida > self.daño(Player):
            Accion = 3
        elif Player.vida > self.daño(Player):
            Accion = 1
        elif Player.vida < self.daño(Player):
            Accion = 1
        else:
            Accion = 1
        return Accion
class Personaje:
    def __init__(self, nombre, vidaMax, ataque, defensa):
        self.nombre = nombre
        self.vidaMax = vidaMax
        self.vida = vidaMax
        self.ataque = ataque
        self.defensa = defensa
        self.vivo = True if self.vida > 0 else False
        self.defendiendo = False

    def atributos(self):
        print(self.nombre + ":") 
        print("     Vida: " + str(self.vida))
        print("     Ataque: " + str(self.ataque))
        print("     Defensa: " + str(self.defensa))
    
    def daño(self, enemigo):
        return self.ataque - enemigo.reduccion_daño()
    
    def reduccion_daño(self):
        return self.defensa

    def curar(self):
        return (self.vidaMax * (self.ataque/3)) + self.vida

    def curarse(self):
        self.vida = (self.vidaMax * (self.ataque/3)) + self.vida

    def atacar(self, enemigo):
        if not enemigo.defendiendo:
            daño = self.daño(enemigo)
            enemigo.vida = enemigo.vida - daño
            print(f"El ataque ha causado {daño} puntos de daño. La vida de {enemigo.nombre} es {enemigo.vida}")
        else:
            print(f"{enemigo.nombre} se esta defendiendo, el ataque no ha causado efecto")

    def EstaVivo(self):
        if self.vida > 0:
            return True
        else:
            return False
class Guerrero(Personaje):
    def __init__(self, nombre, vida, ataque, defensa, espada):
        super().__init__(nombre, vida, ataque, defensa)
        self.espada = espada
    
    def daño(self, enemigo):
        return self.ataque * self.espada - enemigo.reduccion_daño()
class Escudero(Personaje):
    def __init__(self, nombre, vida, ataque, defensa, escudo):
        super().__init__(nombre, vida, ataque, defensa)
        self.escudo = escudo

    def reduccion_daño(self):
        return self.defensa * self.escudo
    
    def daño(self, enemigo):
        return self.ataque + self.escudo - enemigo.reduccion_daño()   


partida = Partida()
partida.creacioPartida()
    




    