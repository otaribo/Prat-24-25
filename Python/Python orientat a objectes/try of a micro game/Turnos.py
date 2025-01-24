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
        self.Iniciar(self.Player, self.CPU)

    def Iniciar(self, Player, CPU):
        self.NumeroTurno = 0
        self.Turno(Player, CPU)

    def Turno(self, Player, CPU):
        Player.defendiendo = False
        CPU.defendiendo = False
        self.Acciones(Player, self.AccionJugador)
        self.Acciones(CPU, self.AccionCPU(CPU, Player))
        self.NumeroTurno += 1
        if Player.vida > 0 and CPU.vida > 0:
            self.Turno(Player, CPU)
        else:
            print("Partida acabada")

    def Acciones(self, Player, Accion):
        if Accion ==1:
            print(f"{Player.nombre} ha atacado causando {Player.daño} puntos de daño")
            Player.atacar
        elif Accion == 2:
            Player.defender
        elif Accion == 3:
            print(f"{Player.nombre} se ha curado {Player.curar} puntos de salud")
            Player.curarse
    def AccionJugador():
        
        while True:
            try:
                Accion = int(input("[1] Atacar \n[2] Defender \n[3] Curarse"))
                if Accion == [1,2,3]:
                    return Accion
            except ValueError:
                    print("Valor Invalid")

    def AccionCPU(self, CPU, Player):
        if CPU.vida <= (CPU.vidaMax/100*30) and Player.vida > CPU.daño(Player):
            Accion = 3
        elif Player.vida > CPU.daño(Player):
            Accion = 1
        elif Player.vida < CPU.daño(Player):
            Accion = 1
        else:
            Accion = 1
        respuesta = Accion
        Accion=0
        return respuesta
        
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
        return (self.ataque - enemigo.reduccion_daño())
    
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
    




    