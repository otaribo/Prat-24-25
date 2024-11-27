class Llibre:
    def __init__(self, nom, autor, any_publicacio):
        self.nom = nom
        self.autor = autor
        self.any_publicacio = any_publicacio

class LlibreFiccio(Llibre):
    def __init__(self, nom, autor, any_publicacio, genere):
        super().__init__(nom, autor, any_publicacio)
        self.genere = genere

class LlibreNoFiccio(Llibre):
    def __init__(self, nom, autor, any_publicacio, area_de_coneixement):
        super().__init__(nom, autor, any_publicacio)
        self.area_de_coneixement = area_de_coneixement

class Soci:
    def __init__(self, nom, dni, llibres_llogats):
        self.nom = nom
        self.dni = dni
        self.llibres_llogats = llibres_llogats
    

class Biblioteca:


