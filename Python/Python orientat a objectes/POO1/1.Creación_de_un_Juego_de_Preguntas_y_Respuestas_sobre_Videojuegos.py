class Pregunta:
    def __init__(self, pregunta, opciones, correcta):
        self.Pregunta = pregunta
        self.Opciones = opciones
        self.Correcta = correcta

    def comprobar(self, resposta):
        if (resposta == self.Correcta):
            print("Resposta Correcta!!!")
            return True
        else:
            print("Resposta Incorrecta!!!")
            return False
        
    
    def mostrarPregunta(self):
        opciones = self.Opciones
        print(f"¿{self.Pregunta}")
        for opcion in opciones:
            posicion = opciones.index(opcion)
            print(f"{posicion+1}. {opcion}")
            


pregunta1 = Pregunta("Maricon", ["Si","No","Puede","Marcion tu"], 3)

while(True):
    pregunta1.mostrarPregunta()
    pregunta1.comprobar(int(input("Selecciona una resposta: "))-1)