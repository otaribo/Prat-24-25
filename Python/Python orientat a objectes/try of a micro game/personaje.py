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
        self.vida = (self.vidaMax * (self.ataque/3)) + self.vida

    def atacar(self, enemigo):
        if not enemigo.defendiendo:
            daño = self.daño(enemigo)
            enemigo.vida = enemigo.vida - daño
            print(f"El ataque ha causado {daño} puntos de daño. La vida de {enemigo.nombre} es {enemigo.vida}")
        else:
            print(f"{enemigo.nombre} se esta defendiendo, el ataque no ha causado efecto")

    def defender(self):
        self.defendiendo = True


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

def Turno(Turno):
    Accion = 0
    while(Accion != 1 or 2 or 3):
        Accion = int(input("[1] Atacar \n[2] Defender \n[3] Curarse"))
        if Accion == 1:
            Personaje1.atacar(Personaje2)
        
        elif Accion == 2:
            Personaje1.defender()

        elif Accion == 3:
            Personaje1.curar()
    
    numeroTurno = numeroTurno + 1

def partida():
    numeroTurno = 0
    while(Personaje1.vivo and Personaje2.vivo):
        Turno(numeroTurno)




Personaje1 = Guerrero("Guerrero", 1000, 16, 5, 5)
Personaje2 = Escudero("Escudero", 1000, 12, 7, 9)
partida()


