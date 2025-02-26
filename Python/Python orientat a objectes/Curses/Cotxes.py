class Cotxe():
    def __init__(self, nom, marca, velocitat_maxima, acceleracio, resistencia):
        self.nom = nom
        self.marca = marca
        self.velocitat_maxima = velocitat_maxima
        self.acceleracio = acceleracio
        self.velocitat = 0
        self.resistencia = resistencia

    def accelerar(self):
        if self.velocitat < self.velocitat_maxima and (self.acceleracio + self.velocitat != self.velocitat_maxima or self.acceleracio + self.velocitat >= self.velocitat_maxima):
            self.velocitat += self.acceleracio
        else:
            self.velocitat = self.velocitat_maxima
        print(f"La velocitat de {self.nom} es de {self.velocitat}.")

    def frenar(self):
        if self.velocitat > 0:
            self.velocitat -= self.acceleracio
            print(f"{self.nom} ha frenat fins {self.velocitat}.")
        else:
            self.velocitat = 0
            print(f"{self.nom} esta parat.")
    
    def rebre_dany(self):
        if self.resistencia > 0:
            self.resistencia -= 10

    def esta_viu(self):
        if self.resistencia > 0:
            return True
        return False
    