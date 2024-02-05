

from PyQt5 import QtCore, QtGui, QtWidgets
import sqlite3

class Ui_Dialog(object):
    def atras(self):
        if self.edicion is True:
            from MainWindow import Ui_MainWindow
            self.window= QtWidgets.QMainWindow()
            self.ui= Ui_MainWindow()
            self.ui.setupUi(self.window, self.nombre)
            self.window.show()
            self.con.close()
            self.ui.salidaButton.clicked.connect(self.window.close)
            self.ui.oportunidadesButton.clicked.connect(self.window.close)
            self.ui.contactosButton.clicked.connect(self.window.close)
            self.ui.inventarioButton.clicked.connect(self.window.close)
            self.ui.pedidosButton.clicked.connect(self.window.close)
            self.ui.presupuestosButton.clicked.connect(self.window.close)
        elif self.edicion is False:
            from nuevaOportunidad2 import Ui_Dialog
            self.window= QtWidgets.QDialog()
            self.ui= Ui_Dialog()
            self.ui.setupUi(self.window,self.nombre,self.contacto)
            self.window.show()
            self.ui.buttonAgregar.clicked.connect(self.window.close)
            self.ui.buttonExistente.clicked.connect(self.window.close)
            self.ui.buttonNuevo.clicked.connect(self.window.close)
            self.con.commit()
            self.con.close()
        
    def elegirItem(self, index):
        item= self.listContactos.model().data(index)
        self.cur.execute("select nombre from contactos where nombre=?",(item,))
        self.contacto = self.cur.fetchone()
        if self.edicion is False:
            from nuevaOportunidad2 import Ui_Dialog
            self.window= QtWidgets.QDialog()
            self.ui= Ui_Dialog()
            self.ui.setupUi(self.window,self.nombre,self.contacto)
            self.window.show()
            self.ui.buttonAgregar.clicked.connect(self.window.close)
            self.ui.buttonExistente.clicked.connect(self.window.close)
            self.ui.buttonNuevo.clicked.connect(self.window.close)
            self.con.commit()
            self.con.close()
        elif self.edicion is True:
            from edicionContacto import Ui_Dialog
            self.window= QtWidgets.QDialog()
            self.ui= Ui_Dialog()
            self.ui.setupUi(self.window, self.nombre, self.contacto)
            self.window.show()
            self.ui.buttonGuardar.clicked.connect(self.window.close)
            self.con.commit()
            self.con.close()
    def setupUi(self, Dialog,nombre,edicion):
        self.edicion= edicion
        self.nombre=nombre
        self.con = sqlite3.connect("BaseDeDatos"+nombre)
        self.cur= self.con.cursor()
        self.cur.execute("select * from contactos")
        contactos= self.cur.fetchall()
        modelo= QtGui.QStandardItemModel()
        Dialog.setObjectName("Dialog")
        Dialog.resize(490, 463)
        self.listContactos = QtWidgets.QListView(Dialog)
        self.listContactos.setGeometry(QtCore.QRect(120, 70, 256, 331))
        self.listContactos.setObjectName("listContactos")
        self.listContactos.setModel(modelo)
        for i in contactos:
            item = QtGui.QStandardItem(i[0])
            modelo.appendRow(item)
        self.listContactos.clicked.connect(self.elegirItem)
        self.label = QtWidgets.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(180, 20, 141, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(16)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.buttonAtras = QtWidgets.QPushButton(Dialog)
        self.buttonAtras.setGeometry(QtCore.QRect(20, 10, 61, 51))
        self.buttonAtras.setText("")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("arrow2.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.buttonAtras.setIcon(icon)
        self.buttonAtras.setIconSize(QtCore.QSize(61, 61))
        self.buttonAtras.setObjectName("buttonAtras")

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Dialog"))
        self.label.setText(_translate("Dialog", "Elige el contacto"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Dialog = QtWidgets.QDialog()
    ui = Ui_Dialog()
    ui.setupUi(Dialog)
    Dialog.show()
    sys.exit(app.exec_())
