
import sqlite3
from PyQt5 import *
from PyQt5 import QtWidgets, QtCore
from PyQt5.QtWidgets import *

class Ui_Login(object):
    def abrirMainWindow(self, nombre):
        from MainWindow import Ui_MainWindow
        self.window= QtWidgets.QMainWindow()
        self.ui= Ui_MainWindow()
        self.ui.setupUi(self.window,nombre)
        self.window.show()
        Login.hide()
        self.ui.salidaButton.clicked.connect(self.window.close)
        self.ui.oportunidadesButton.clicked.connect(self.window.close)
        self.ui.contactosButton.clicked.connect(self.window.close)
        self.ui.inventarioButton.clicked.connect(self.window.close)
        self.ui.pedidosButton.clicked.connect(self.window.close)
        self.ui.presupuestosButton.clicked.connect(self.window.close)
        self.ui.actionSalir.triggered.connect(self.window.close)
    def abrirRegistro(self):
        from registro import Ui_Dialog
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Dialog()
        self.ui.setupUi(self.window)
        self.window.show()
        Login.hide()
        self.ui.pushButton.clicked.connect(self.window.close)
    def buscarLogin(self,nombre,correo, password):
        try:
            con = sqlite3.connect("BaseDeDatosEmpresas")
            cur= con.cursor()
            cur.execute("select * from empresas where nombreEmpresa=?",(nombre,))
            empresa= cur.fetchone()
            
            if(empresa==None):
                msgBox = QMessageBox()
                msgBox.setText("La empresa introducida no existe")
                msgBox.setWindowTitle("Error")
                msgBox.setIcon(QMessageBox.Critical)
                msgBox.exec()
            else:
                datos=[(nombre,correo,password)]
                cur.execute("select * from empresas where nombreEmpresa=? and correo=? and password=?",datos[0])
                empresa= cur.fetchone()
                if(empresa==None):
                    msgBox = QMessageBox()
                    msgBox.setText("Los datos introducidos no son correctos")
                    msgBox.setWindowTitle("Error")
                    msgBox.setIcon(QMessageBox.Critical)
                    msgBox.exec()
                else:
                    self.abrirMainWindow(nombre)
            con.commit()
            con.close()
        except Exception as a:
            print(a)

    def setupUi(self, Login):
        Login.setObjectName("Login")
        Login.resize(400, 300)
        self.label = QtWidgets.QLabel(Login)
        self.label.setGeometry(QtCore.QRect(40, 60, 71, 21))
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(Login)
        self.label_2.setGeometry(QtCore.QRect(40, 100, 47, 13))
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(Login)
        self.label_3.setGeometry(QtCore.QRect(40, 140, 71, 16))
        self.label_3.setObjectName("label_3")
        self.lineEdit = QtWidgets.QLineEdit(Login)
        self.lineEdit.setGeometry(QtCore.QRect(140, 60, 191, 20))
        self.lineEdit.setObjectName("lineEdit")
        self.lineEdit_2 = QtWidgets.QLineEdit(Login)
        self.lineEdit_2.setGeometry(QtCore.QRect(140, 100, 191, 20))
        self.lineEdit_2.setObjectName("lineEdit_2")
        self.lineEdit_3 = QtWidgets.QLineEdit(Login)
        self.lineEdit_3.setGeometry(QtCore.QRect(140, 140, 191, 20))
        self.lineEdit_3.setObjectName("lineEdit_3")
        self.lineEdit_3.setEchoMode(QLineEdit.EchoMode.Password)
        self.entrar = QtWidgets.QPushButton(Login, clicked= lambda: self.buscarLogin(self.lineEdit.text(),self.lineEdit_2, self.lineEdit_3.text()))
        self.entrar.setGeometry(QtCore.QRect(80, 220, 75, 23))
        self.entrar.setObjectName("entrar")
        self.registro = QtWidgets.QPushButton(Login,clicked= lambda: self.abrirRegistro())
        self.registro.setGeometry(QtCore.QRect(220, 220, 75, 23))
        self.registro.setObjectName("registro")

        self.retranslateUi(Login)
        QtCore.QMetaObject.connectSlotsByName(Login)

    def retranslateUi(self, Login):
        _translate = QtCore.QCoreApplication.translate
        Login.setWindowTitle(_translate("Login", "Dialog"))
        self.label.setText(_translate("Login", "Empresa"))
        self.label_2.setText(_translate("Login", "Correo"))
        self.label_3.setText(_translate("Login", "Contraseña"))
        self.entrar.setText(_translate("Login", "Entrar"))
        self.registro.setText(_translate("Login", "Registro"))
        
    


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Login = QtWidgets.QDialog()
    ui = Ui_Login()
    ui.setupUi(Login)
    Login.show()
    sys.exit(app.exec_())
