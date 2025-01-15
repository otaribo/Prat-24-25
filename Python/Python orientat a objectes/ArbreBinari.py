class Node:
    def __init__(self, valor):
        self.valor = valor
        self.esquerra = None
        self.dreta = None
 
class ArbreBinari:
    def __init__(self):
        self.arrel = None
 
    def inserir(self, valor):
        if self.arrel is None:
            self.arrel = Node(valor)
        else:
            self._inserir_recursivament(self.arrel, valor)
 
    def _inserir_recursivament(self, node, valor):
        if valor < node.valor:
            if node.esquerra is None:
                node.esquerra = Node(valor)
            else:
                self._inserir_recursivament(node.esquerra, valor)
        else:
            if node.dreta is None:
                node.dreta = Node(valor)
            else:
                self._inserir_recursivament(node.dreta, valor)
 
    def inorder(self, node):
        if node is not None:
            self.inorder(node.esquerra)
            print(node.valor, end=" ")
            self.inorder(node.dreta)
 
# Prova de l'exemple
arbre = ArbreBinari()
valors = [50, 30, 70, 20, 40, 60, 80]
for valor in valors:
    arbre.inserir(valor)
 
print("Recorregut en ordre (Inorder):")
arbre.inorder(arbre.arrel)
