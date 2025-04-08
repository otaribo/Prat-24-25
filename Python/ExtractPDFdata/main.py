import fitz  # PyMuPDF
import os
path = os.path.dirname(os.path.abspath(__file__))

def pdf_to_txt(pdf_path, txt_path):
    doc = fitz.open(pdf_path)
    texto_completo = ""
    for pagina in doc:
        texto_completo += pagina.get_text()
    with open(txt_path, 'w', encoding='utf-8') as archivo_txt:
        archivo_txt.write(texto_completo)
pdf_to_txt(os.path.join(path,'data.pdf'), os.path.join(path, 'data.txt'))