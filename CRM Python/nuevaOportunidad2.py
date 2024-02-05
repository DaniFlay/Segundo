

from PyQt5 import QtCore, QtGui, QtWidgets
import sqlite3

class Ui_Dialog(object):
    def nuevo(self, nombre):
        from nuevoContacto import Ui_Dialog
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Dialog()
        pestContactos= False
        self.ui.setupUi(self.window, nombre, pestContactos)
        self.window.show()
        self.ui.buttonCrear.clicked.connect(self.window.close)
    def existente(self,nombre):
        from elegirCon import Ui_Dialog
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Dialog()
        self.ui.setupUi(self.window,nombre,False)
        self.window.show()
        self.ui.listContactos.clicked.connect(self.window.close)
    def setupUi(self, Dialog, nombre, contacto=None):
        self.con = sqlite3.connect("BaseDeDatos"+nombre)
        self.cur= self.con.cursor()
        Dialog.setObjectName("Dialog")
        Dialog.resize(461, 396)
        self.oportunidad = QtWidgets.QLineEdit(Dialog)
        self.oportunidad.setGeometry(QtCore.QRect(130, 70, 201, 20))
        self.oportunidad.setObjectName("oportunidad")
        self.ingresoEsperado = QtWidgets.QLineEdit(Dialog)
        self.ingresoEsperado.setGeometry(QtCore.QRect(130, 150, 201, 20))
        self.ingresoEsperado.setObjectName("ingresoEsperado")
        self.correo = QtWidgets.QLineEdit(Dialog)
        self.correo.setGeometry(QtCore.QRect(130, 190, 201, 20))
        self.correo.setObjectName("correo")
        self.telefono = QtWidgets.QLineEdit(Dialog)
        self.telefono.setGeometry(QtCore.QRect(130, 230, 201, 20))
        self.telefono.setObjectName("telefono")
        self.tipo = QtWidgets.QLineEdit(Dialog)
        self.tipo.setGeometry(QtCore.QRect(130, 270, 201, 20))
        self.tipo.setObjectName("tipo")
        self.label = QtWidgets.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(10, 70, 81, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(10, 110, 81, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_2.setFont(font)
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(10, 150, 111, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_3.setFont(font)
        self.label_3.setObjectName("label_3")
        self.label_4 = QtWidgets.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(10, 190, 81, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_4.setFont(font)
        self.label_4.setObjectName("label_4")
        self.label_5 = QtWidgets.QLabel(Dialog)
        self.label_5.setGeometry(QtCore.QRect(10, 230, 81, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_5.setFont(font)
        self.label_5.setObjectName("label_5")
        self.label_6 = QtWidgets.QLabel(Dialog)
        self.label_6.setGeometry(QtCore.QRect(10, 270, 81, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_6.setFont(font)
        self.label_6.setObjectName("label_6")
        self.buttonAgregar = QtWidgets.QPushButton(Dialog)
        self.buttonAgregar.setGeometry(QtCore.QRect(160, 330, 75, 23))
        self.buttonAgregar.setObjectName("buttonAgregar")
        self.label_7 = QtWidgets.QLabel(Dialog)
        self.label_7.setGeometry(QtCore.QRect(120, 10, 171, 41))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(16)
        self.label_7.setFont(font)
        self.label_7.setObjectName("label_7")
        self.buttonExistente = QtWidgets.QPushButton(Dialog, clicked= lambda:self.existente(nombre))
        self.buttonExistente.setGeometry(QtCore.QRect(350, 110, 31, 31))
        self.buttonExistente.setText("")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("contactos2.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.buttonExistente.setIcon(icon)
        self.buttonExistente.setObjectName("buttonExistente")
        self.buttonNuevo = QtWidgets.QPushButton(Dialog,clicked=lambda:self.nuevo(nombre))
        self.buttonNuevo.setGeometry(QtCore.QRect(400, 110, 31, 31))
        self.buttonNuevo.setText("")
        icon1 = QtGui.QIcon()
        icon1.addPixmap(QtGui.QPixmap("plus.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.buttonNuevo.setIcon(icon1)
        self.buttonNuevo.setObjectName("buttonNuevo")
        self.contacto = QtWidgets.QLineEdit(Dialog)
        self.contacto.setGeometry(QtCore.QRect(130, 110, 201, 20))
        self.contacto.setReadOnly(True)
        self.contacto.setObjectName("contacto")
        if(contacto is not None):
            self.contacto.setText(contacto[0])

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

  
    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Dialog"))
        self.label.setText(_translate("Dialog", "Oportunidad"))
        self.label_2.setText(_translate("Dialog", "Contacto"))
        self.label_3.setText(_translate("Dialog", "Ingreso Esperado"))
        self.label_4.setText(_translate("Dialog", "Correo"))
        self.label_5.setText(_translate("Dialog", "Telefono"))
        self.label_6.setText(_translate("Dialog", "Tipo"))
        self.buttonAgregar.setText(_translate("Dialog", "Agregar"))
        self.label_7.setText(_translate("Dialog", "Nueva Oportunidad"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Dialog = QtWidgets.QDialog()
    ui = Ui_Dialog()
    ui.setupUi(Dialog)
    Dialog.show()
    sys.exit(app.exec_())
