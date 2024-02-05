import sqlite3
from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_Dialog(object):
    def guardarContacto(self):
        datoNombre= self.nombre.text()
        datoPais= self.pais.text()
        datoCiudad= self.ciudad.text()
        datoCP= self.cp.text()
        datoCalle= self.calle.text()
        datoContacto= self.contacto.text()
        datoTelefono= self.telefono.text()
        datoCorreo= self.correo.text()
        datoIVA= float(self.iva.text())
        datoDireccion= datoCalle+", "+datoCP+", "+datoCiudad+", "+datoPais
        datos= [(datoNombre,datoDireccion,datoContacto, datoTelefono,datoCorreo,datoIVA)]
        print(datos)
        self.cur.execute("insert into contactos values(?,?,?,?,?,?)",datos[0])
        self.con.commit()
        self.con.close()
        if(self.pestContacto is False):
            from nuevaOportunidad2 import Ui_Dialog
            self.window= QtWidgets.QDialog()
            self.ui= Ui_Dialog()
            self.ui.setupUi(self.window,self.nombre)
            self.window.show()
            self.ui.buttonAgregar.clicked.connect(self.window.close)
            self.ui.buttonExistente.clicked.connect(self.window.close)
            self.ui.buttonNuevo.clicked.connect(self.window.close)
         
    def setupUi(self, Dialog,nombre,pestContacto):
        self.pestContacto= pestContacto
        Dialog.setObjectName("Dialog")
        Dialog.resize(506, 512)
        self.con= sqlite3.connect("BaseDeDatos"+nombre)
        self.cur= self.con.cursor()
        self.label = QtWidgets.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(170, 10, 161, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.nombre = QtWidgets.QLineEdit(Dialog)
        self.nombre.setGeometry(QtCore.QRect(130, 70, 231, 20))
        self.nombre.setObjectName("nombre")
       
        self.pais = QtWidgets.QLineEdit(Dialog)
        self.pais.setGeometry(QtCore.QRect(130, 110, 231, 20))
        self.pais.setObjectName("pais")
        
        self.ciudad = QtWidgets.QLineEdit(Dialog)
        self.ciudad.setGeometry(QtCore.QRect(130, 150, 231, 20))
        self.ciudad.setObjectName("ciudad")
        
        self.cp = QtWidgets.QLineEdit(Dialog)
        self.cp.setGeometry(QtCore.QRect(130, 190, 231, 20))
        self.cp.setObjectName("cp")
        
        self.calle = QtWidgets.QLineEdit(Dialog)
        self.calle.setGeometry(QtCore.QRect(130, 230, 231, 20))
        self.calle.setObjectName("calle")
        
        self.contacto = QtWidgets.QLineEdit(Dialog)
        self.contacto.setGeometry(QtCore.QRect(130, 270, 231, 20))
        self.contacto.setObjectName("contacto")
        
        self.telefono = QtWidgets.QLineEdit(Dialog)
        self.telefono.setGeometry(QtCore.QRect(130, 310, 231, 20))
        self.telefono.setObjectName("telefono")
        
        self.correo = QtWidgets.QLineEdit(Dialog)
        self.correo.setGeometry(QtCore.QRect(130, 350, 231, 20))
        self.correo.setObjectName("correo")
       
        self.iva = QtWidgets.QLineEdit(Dialog)
        self.iva.setGeometry(QtCore.QRect(130, 390, 231, 20))
        self.iva.setObjectName("iva")
        
        self.label_2 = QtWidgets.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(20, 70, 47, 13))
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(20, 110, 47, 13))
        self.label_3.setObjectName("label_3")
        self.label_4 = QtWidgets.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(20, 150, 47, 13))
        self.label_4.setObjectName("label_4")
        self.label_5 = QtWidgets.QLabel(Dialog)
        self.label_5.setGeometry(QtCore.QRect(20, 190, 47, 13))
        self.label_5.setObjectName("label_5")
        self.label_6 = QtWidgets.QLabel(Dialog)
        self.label_6.setGeometry(QtCore.QRect(20, 230, 47, 13))
        self.label_6.setObjectName("label_6")
        self.label_7 = QtWidgets.QLabel(Dialog)
        self.label_7.setGeometry(QtCore.QRect(20, 270, 47, 13))
        self.label_7.setObjectName("label_7")
        self.label_8 = QtWidgets.QLabel(Dialog)
        self.label_8.setGeometry(QtCore.QRect(20, 310, 47, 13))
        self.label_8.setObjectName("label_8")
        self.label_9 = QtWidgets.QLabel(Dialog)
        self.label_9.setGeometry(QtCore.QRect(20, 350, 47, 13))
        self.label_9.setObjectName("label_9")
        self.label_10 = QtWidgets.QLabel(Dialog)
        self.label_10.setGeometry(QtCore.QRect(20, 390, 47, 13))
        self.label_10.setObjectName("label_10")
        self.buttonCrear = QtWidgets.QPushButton(Dialog, clicked=lambda:self.guardarContacto())
        self.buttonCrear.setGeometry(QtCore.QRect(190, 440, 75, 23))
        self.buttonCrear.setObjectName("buttonCrear")

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Dialog"))
        self.label.setText(_translate("Dialog", "Nuevo contacto"))
        self.label_2.setText(_translate("Dialog", "Nombre"))
        self.label_3.setText(_translate("Dialog", "País"))
        self.label_4.setText(_translate("Dialog", "Ciudad"))
        self.label_5.setText(_translate("Dialog", "CP"))
        self.label_6.setText(_translate("Dialog", "Calle"))
        self.label_7.setText(_translate("Dialog", "Contacto"))
        self.label_8.setText(_translate("Dialog", "Teléfono"))
        self.label_9.setText(_translate("Dialog", "Correo"))
        self.label_10.setText(_translate("Dialog", "IVA"))
        self.buttonCrear.setText(_translate("Dialog", " Crear"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Dialog = QtWidgets.QDialog()
    ui = Ui_Dialog()
    ui.setupUi(Dialog)
    Dialog.show()
    sys.exit(app.exec_())
