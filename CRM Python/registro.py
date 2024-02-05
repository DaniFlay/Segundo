
import sqlite3

from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import *
from window import *


class Ui_Dialog(object):
    def baseDeDatos(self, empresa, telefono,correo,pais, password):
        try:
            nombreBBDD= "BaseDeDatos"+empresa
            con = sqlite3.connect(nombreBBDD)
            cur= con.cursor()
            cur.execute("create table if not exists empresa(nombreEmpresa varchar(50) primary key, telefono varchar(10), correo varchar(40),pais varchar(20), password varchar(40))")
            nuevaEmpresa= [(empresa, telefono, correo, pais,password)]
            cur.execute("insert into empresa values (?,?,?,?,?)", nuevaEmpresa[0])
            cur.execute("create table if not exists contactos( nombre varchar(50),direccion varchar(300),contacto varchar(30), telefono varchar(15), correo varchar(50), IVA double)")
            cur.execute("create table if not exists oportunidades( contacto integer, oportunidad varchar(100),presupuesto integer, correo varchar(50), telefono varchar(15),ingresoEsperado double, tipo varchar(20), foreign key(contacto)references contactos(id), foreign key (presupuesto)references presupuestos(id))")
            cur.execute("create table if not exists inventario( nombre varchar(100), cantidad integer,descripcion varchar(500), precio double)")
            cur.execute("create table if not exists pedidos(id varchar(50) primary key, contacto integer, producto integer, cantidad integer, fecha varchar(10),precio double, foreign key(contacto) references contactos(id), foreign key(producto) references productos(id))")
            cur.execute("create table if not exists presupuestos( presupuesto varchar(50), contacto integer,pedido integer, total double,fecha varchar(10),foreign key (presupuesto) references presupuestos(id), foreign key (contacto) references contactos(id), foreign key(fecha) references pedidos(fecha))")
            con.commit()
            con.close()
        except Exception as a:
            print(a)
    def abrirLogin(self):
       
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Login()
        self.ui.setupUi(self.window)
        self.window.show()
        
    def crearNuevaEmpresa(self,empresa, telefono,correo,pais, password):
        try:
            con = sqlite3.connect("BaseDeDatosEmpresas")
            cur= con.cursor()
            nuevaEmpresa= [(empresa, telefono, correo, pais,password)]
            cur.execute("create table if not exists empresas(nombreEmpresa varchar(50) primary key, telefono varchar(10), correo varchar(40),pais varchar(20), password varchar(40))")
            cur.execute("select * from empresas where nombreEmpresa=?",(empresa,))
            empresaN= cur.fetchone()
            if(empresaN==None):
                cur.execute("insert into empresas values (?,?,?,?,?)", nuevaEmpresa[0])
                msgBox = QMessageBox()
                msgBox.setText("La empresa ha sido creada con éxito")
                msgBox.setWindowTitle("Information")
                msgBox.setIcon(QMessageBox.Information)
                msgBox.exec()
                self.baseDeDatos(empresa, telefono,correo,pais, password)
                self.abrirLogin()
               
            else:
                msgBox = QMessageBox()
                msgBox.setText("La empresa introducida ya existe")
                msgBox.setWindowTitle("Error")
                msgBox.setIcon(QMessageBox.Critical)
                msgBox.exec()
            con.commit()
            con.close()
        except Exception as a:
            print(a)
   
    def setupUi(self, Dialog):
        Dialog.setObjectName("Dialog")
        Dialog.resize(400, 300)
        Dialog.setCursor(QtGui.QCursor(QtCore.Qt.ArrowCursor))
        self.pushButton = QtWidgets.QPushButton(Dialog, clicked= lambda: self.crearNuevaEmpresa(self.lineEdit.text(), self.lineEdit_2.text(), self.lineEdit_3.text(), self.lineEdit_4.text(), self.lineEdit_5.text()))
        self.pushButton.setGeometry(QtCore.QRect(160, 240, 75, 23))
        self.pushButton.setObjectName("pushButton")
        self.label = QtWidgets.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(60, 40, 61, 16))
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(60, 70, 61, 16))
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(60, 100, 61, 16))
        self.label_3.setObjectName("label_3")
        self.label_4 = QtWidgets.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(60, 130, 61, 16))
        self.label_4.setObjectName("label_4")
        self.label_5 = QtWidgets.QLabel(Dialog)
        self.label_5.setGeometry(QtCore.QRect(60, 160, 61, 16))
        self.label_5.setObjectName("label_5")
        self.label_6 = QtWidgets.QLabel(Dialog)
        self.label_6.setGeometry(QtCore.QRect(60, 190, 91, 21))
        self.label_6.setObjectName("label_6")
        self.lineEdit = QtWidgets.QLineEdit(Dialog)
        self.lineEdit.setGeometry(QtCore.QRect(170, 40, 171, 20))
        self.lineEdit.setObjectName("lineEdit")
        self.lineEdit_2 = QtWidgets.QLineEdit(Dialog)
        self.lineEdit_2.setGeometry(QtCore.QRect(170, 70, 171, 20))
        self.lineEdit_2.setObjectName("lineEdit_2")
        self.lineEdit_3 = QtWidgets.QLineEdit(Dialog)
        self.lineEdit_3.setGeometry(QtCore.QRect(170, 100, 171, 20))
        self.lineEdit_3.setObjectName("lineEdit_3")
        self.lineEdit_4 = QtWidgets.QLineEdit(Dialog)
        self.lineEdit_4.setGeometry(QtCore.QRect(170, 130, 171, 20))
        self.lineEdit_4.setObjectName("lineEdit_4")
        self.lineEdit_5 = QtWidgets.QLineEdit(Dialog)
        self.lineEdit_5.setGeometry(QtCore.QRect(170, 160, 171, 20))
        self.lineEdit_5.setObjectName("lineEdit_5")
        self.lineEdit_5.setEchoMode(QLineEdit.EchoMode.Password)
        self.lineEdit_6 = QtWidgets.QLineEdit(Dialog)
        self.lineEdit_6.setGeometry(QtCore.QRect(170, 190, 171, 20))
        self.lineEdit_6.setObjectName("lineEdit_6")
        self.lineEdit_6.setEchoMode(QLineEdit.EchoMode.Password)

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Registro"))
        self.pushButton.setText(_translate("Dialog", "Registrarse"))
        self.label.setText(_translate("Dialog", "Empresa"))
        self.label_2.setText(_translate("Dialog", "Telefono"))
        self.label_3.setText(_translate("Dialog", "Correo"))
        self.label_4.setText(_translate("Dialog", "País"))
        self.label_5.setText(_translate("Dialog", "Contraseña"))
        self.label_6.setText(_translate("Dialog", "Repetir contraseña"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Dialog = QtWidgets.QDialog()
    ui = Ui_Dialog()
    ui.setupUi(Dialog)
    Dialog.show()
    sys.exit(app.exec_())