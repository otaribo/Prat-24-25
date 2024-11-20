class alumne:
    def __init__(self, nom, cognom, edat, assignatura, nota):
        self.nom = nom
        self.cognom = cognom
        self.edat = edat
        self.assignatura = assignatura
        self.nota = nota

    def consultar_nota(self):
        print(f"La nota de {self.assignatura} es {self.nota}")
    
    def cambiar_nota(self, nota):
        self.nota = nota

    def actualitzar_edat(self, edat):
        if edat > 0
        self.edat = edat