import heapq
import os

Path = "C:\\Github\\Prat-24-25\\Python\\Python orientat a objectes\\CuaDePrioritat\\Documents"
Documents = os.listdir(Path)
Orden = {}



class Documento:
    def __init__(self):
        self.nombre = None
        self.prioridad = None

for file in Documents:
    file_path = os.path.join(Path,file)
    str(file) = Documento()
    

def checkContent(file_path):
    try:       
        with open(file_path, "r", encoding="utf-8") as archive:
            content = archive.read()
            return content
    except Exception as e:
        print(f"Error reading file {file}: {e}")


    
