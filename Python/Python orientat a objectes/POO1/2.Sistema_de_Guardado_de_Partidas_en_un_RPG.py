import json

RayoSave = "Python/Python orientat a objectes/POO1/EstadoRayo.json"
GandalfSave = "Python/Python orientat a objectes/POO1/EstadoGandalf.json"

class Personaje:
    def __init__(self, nombre, nivel, experiencia, inventario):
        self.nombre = nombre
        self.nivel = nivel
        self.experiencia = experiencia
        self.inventario = inventario


    def guardar(self, archivo):
        with open(archivo, "w") as f:
            json.dump(self.Estado(), f)

    def cargar(self, archivo):
        with open(archivo, "r") as f:
            data = json.load(f)
            self.nombre = data["nombre"]
            self.nivel = data["nivel"]
            self.experiencia = data["experiencia"]
            self.inventario = data["inventario"]


    def Estado(self):
        return {
            "nombre": self.nombre,
            "nivel": self.nivel,
            "experiencia": self.experiencia,
            "inventario": self.inventario
        }
    
Personaje1 = Personaje("Gandalf", 10, 100, ["Espada", "Baston"])
Personaje2 = Personaje("RayoMCQueen", 25, 73, ["Rueda", "Tubo de escape"])
Personaje1.guardar(GandalfSave)
Personaje2.guardar(RayoSave)
print(Personaje1.nombre)
Personaje1.cargar(RayoSave)
print(Personaje1.nombre)