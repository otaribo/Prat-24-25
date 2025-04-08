import xml.etree.ElementTree as ElementTree
import json
import os
path = os.path.dirname(os.path.abspath(__file__))

def convert_xml_to_json(xml_file, json_file):
    tree = ElementTree.parse(xml_file)
    root = tree.getroot()
    alumnos = []
    for alumno in root.findall('alumno'):
        alumno_data = {
            "nombre": alumno.find('nombre').text,
            "edad": alumno.find('edad').text,
            "curso": alumno.find('curso').text
        }
        alumnos.append(alumno_data)
    with open(json_file, 'w', encoding='utf-8') as f:
        json.dump(alumnos, f, indent=4, ensure_ascii=False)


convert_xml_to_json(os.path.join(path, 'archivo.xml'), os.path.join(path, 'archivo.json'))