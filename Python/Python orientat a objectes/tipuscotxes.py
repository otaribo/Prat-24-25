class Cotxe:
    def __init__(self, tipus_motor, combustible, portes):
        self.tipus_motor = tipus_motor
        self.combustible = combustible
        self.portes = portes

    def get_tipus_motor(self):
        print(f"El motor es per {self.tipus_motor}")

    def get_combustible(self):
        print(f"El combustible es {self.combustible}")

    def get_portes(self):
        print(f"El cotxe te {self.portes} portes")

class Audi(Cotxe):
    def __init__ (self, tipus_motor, combustible, portes, cv, longitut, amplada):
        super().__init__(tipus_motor, combustible, portes)

        self.cv = cv
        self.longitut = longitut
        self.amplada = amplada

    def get_cv(self):
        print(f"El cotxe te {self.cv}cv")
    
    def get_longitut(self):
        print(f"El cotxe te una longitut de {self.longitut} metres")

    def get_amplada(self):
        print(f"El cotxe te una amplada de {self.amplada} metres")
          
class Mercedes(Cotxe):
    def __init__ (self, tipus_acabat):
        self.tipus_acabat = tipus_acabat



cotxe1 = Audi("combustio", "gasolina" , 5, 595, 5.30, 3.10)

cotxe1.get_combustible()
cotxe1.get_portes()
cotxe1.get_tipus_motor()
cotxe1.get_cv()
cotxe1.get_longitut()
cotxe1.get_amplada()
