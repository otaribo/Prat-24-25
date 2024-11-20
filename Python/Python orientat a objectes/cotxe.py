class Cotxe:
    def __init__(self, estat, velocitat):
        self.estat = estat
        self.velocitat = velocitat
    
    def estat_on(self):
        if self.estat == "on":
            print("El cotxe ja esta ences")
        else:
            self.estat = "on"

    def estat_off(self):
        if self.estat == "off":
            print("El cotxe ja esta apagat")
        else:
            self.estat = "off"

    def aumentar_velocitat(self, kmh):
        if self.estat == "on":
            if self.velocitat + kmh > 120:
                print("No pots aumentar la velocitat a mes de 120kmh")
                self.velocitat = 120
            elif self.velocitat + kmh < self.velocitat:
                print("No pots accelerar enrere")
            else:
                self.velocitat+=kmh
                print(f"La velocitat ha aumentat fins {self.velocitat}kmh")
        else:
            print("el cotxe esta apagat")

    def frenar(self, kmh):
        if self.estat == "on":
            if self.velocitat - kmh > self.velocitat:
                print("no es posible accelera mentres frenes")
            elif self.velocitat - kmh < 0:
                print("es frenar no marxa enrere")
            elif self.velocitat - kmh < self.velocitat and self.velocitat - kmh >= 0:
                self.velocitat -= kmh
                print(f"La velocitat s'ha reuit fins {self.velocitat}kmh")
        else:
            print("el cotxe esta apagat")
    
    def velocimetre(self):
        print(f"La velocitat del cotxe es {self.velocitat}kmh")


cotxe1 = Cotxe(estat="off", velocitat=0)
cotxe1.estat_on()
cotxe1.aumentar_velocitat(126)
cotxe1.frenar(26)
cotxe1.velocimetre()
            
            