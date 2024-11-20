class Lavadora:
    def __init__(self, carga, estat):
        self.carga = carga
        self.estat = estat
    
    def Encendre(self):
        if self.estat == "Encesa":
            print("La lavadora ja esta encesa")
        else:
            self.estat = "Encesa"
            print("La lavadora esta Encesa")

    def Apagar(self):
        self.estat = "Apagada"
        print("La lavadora esta apagada")

    def treure_roba(self):
        if self.estat == "Apagada":
            self.carga = 0
        if self.estat == "Encesa":
            print("no pots retirar la roba perque lalavadora esta encesa")

    def posar_roba(self, kg):
        if self.estat == "Apagada":
            if self.carga + kg <= 8:
                self.carga+=kg
                print(f"La lavadora te {self.carga}kg de roba")
            else:
                print("no cap mas ropa")
            

lavadora1 = Lavadora(carga=0,estat="Apagada")




