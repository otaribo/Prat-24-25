from lxml import etree
import os
# Llegir els fitxers XML i XSL
ruta = os.path.dirname(os.path.abspath(__file__))
rutaxml = os.path.join(ruta,"llibres.xml")
rutaxsl = os.path.join(ruta,"llibres.xsl")
xml_doc = etree.parse(rutaxml)
xsl_doc = etree.parse(rutaxsl)
 
# Crear l'objecte transformador
transformador = etree.XSLT(xsl_doc)
 
# Aplicar la transformació
html_resultat = transformador(xml_doc)
 
# Guardar el resultat com a fitxer HTML
with open(os.path.join(ruta,"resultat.html"), "w", encoding="utf-8") as f:
    f.write(str(html_resultat))
