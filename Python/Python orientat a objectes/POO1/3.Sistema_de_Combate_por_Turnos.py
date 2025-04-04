class Personaje:
    def __init__(self, nombre, vida, ataque, defensa):
        self.Nombre = nombre
        self.Vida = vida
        self.Ataque = ataque
        self.Defensa = defensa

    def atacar(self):
        print(f"{self.Nombre} ha atacado con un total de {self.Ataque} puntos de daño.")

class Mago(Personaje):
    def __init__(self, nombre, vida, ataque, defensa, ataque_magico, mana):
        super().__init__(nombre, vida, ataque, defensa)
        self.Ataque_magico = ataque_magico
        self.Mana = mana

    def atacar(self):
        print(f"{self.Nombre} ha atacado con un total de {self.Ataque_magico + self.Mana/2} puntos de daño.")

class Guerrero(Personaje):
    def __init__(self, nombre, vida, ataque, defensa, nivel_espada):
        super().__init__(nombre, vida, ataque, defensa)
        self.Nivel_Espada = nivel_espada
    
    def atacar(self):
        print(f"{self.Nombre} ha atacado con un total de {self.Ataque * self.Nivel_Espada}puntos de daño.")

class Arquero(Personaje):
    def __init__(self, nombre, vida, ataque, defensa, presicion):
        super().__init__(nombre, vida, ataque, defensa)
        self.Presicion = presicion

    def atacar(self):
        print(f"{self.Nombre} ha atacado con un total de {self.Ataque * (1 if self.Presicion<5 else 3)} puntos de daño.")

personajeBase = Personaje("Base", 150, 15, 10)
mago = Mago("Mago", 100, 9, 8, 13, 35)
guerrero = Guerrero("Guerrero", 200, 15, 12, 2)
arquero = Arquero("Arquero", 125, 16, 10, 6)
mago.atacar()
guerrero.atacar()
arquero.atacar()
personajeBase.atacar()

    
