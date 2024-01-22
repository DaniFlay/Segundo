
from PyQt5 import QtCore, QtGui, QtWidgets
import sqlite3
from MainWindow import *

class Ui_Pipeline(object):
    def editar(self,nombre,oportunidad):
        from editar import Ui_Dialog
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Dialog
        self.ui.setupUi(self.window, nombre,oportunidad)
        self.window.show()
    def nuevaOportunidad(self, nombre):
        from nuevaOportunidad import Ui_Dialog
        self.window= QtWidgets.QDialog()
        self.ui= Ui_Dialog()
        self.ui.setupUi(self.window,nombre)
        self.window.show()
        self.ui.buttonAgregar.clicked.connect(self.window.close)
    def atras(self, nombre):
        from MainWindow import Ui_MainWindow
        self.window= QtWidgets.QMainWindow()
        self.ui= Ui_MainWindow()
        self.ui.setupUi(self.window, nombre)
        self.window.show()
        self.ui.salidaButton.clicked.connect(self.window.close)
        self.ui.oportunidadesButton.clicked.connect(self.window.close)
        self.ui.contactosButton.clicked.connect(self.window.close)
        self.ui.inventarioButton.clicked.connect(self.window.close)
        self.ui.pedidosButton.clicked.connect(self.window.close)
        self.ui.presupuestosButton.clicked.connect(self.window.close)
    def nuevos(self, empresa):
        bbdd= "BaseDeDatos"+empresa
        con = sqlite3.connect(bbdd)
        cur = con.cursor()
        cur.execute("select oportunidad from oportunidades where tipo = 'nuevo' collate nocase")
        oportunidades= cur.fetchall()
        return oportunidades
    def calificados(self, empresa):
        bbdd= "BaseDeDatos"+empresa
        con = sqlite3.connect(bbdd)
        cur = con.cursor()
        cur.execute("select oportunidad from oportunidades where tipo='calificado' collate nocase")
        oportunidades= cur.fetchall()
        return oportunidades
    def propuestas(self, empresa):
        bbdd= "BaseDeDatos"+empresa
        con = sqlite3.connect(bbdd)
        cur = con.cursor()
        cur.execute("select oportunidad from oportunidades where tipo='propuesta' collate nocase")
        oportunidades= cur.fetchall()
        return oportunidades
    def ganados(self, empresa):
        bbdd= "BaseDeDatos"+empresa
        con = sqlite3.connect(bbdd)
        cur = con.cursor()
        cur.execute("select oportunidad from oportunidades where tipo= 'ganado' collate nocase")
        oportunidades= cur.fetchall()
        return oportunidades
    def setupUi(self, MainWindow,nombre):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(882, 701)
        modeloNuevos= QtGui.QStandardItemModel()
        modeloCalificados= QtGui.QStandardItemModel()
        modeloPropuestas= QtGui.QStandardItemModel()
        modeloGanados= QtGui.QStandardItemModel()
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.buttonAtras = QtWidgets.QPushButton(self.centralwidget, clicked=lambda: self.atras(nombre))
        self.buttonAtras.setGeometry(QtCore.QRect(20, 10, 61, 51))
        self.buttonAtras.setText("")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("arrow2.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.buttonAtras.setIcon(icon)
        self.buttonAtras.setIconSize(QtCore.QSize(61, 61))
        self.buttonAtras.setObjectName("buttonAtras")
        self.labelPipeline = QtWidgets.QLabel(self.centralwidget)
        self.labelPipeline.setGeometry(QtCore.QRect(390, 10, 111, 51))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(24)
        font.setBold(False)
        font.setWeight(50)
        self.labelPipeline.setFont(font)
        self.labelPipeline.setObjectName("labelPipeline")
        self.buttonNuevo = QtWidgets.QPushButton(self.centralwidget, clicked= lambda: self.nuevaOportunidad(nombre))
        self.buttonNuevo.setGeometry(QtCore.QRect(800, 10, 61, 51))
        self.buttonNuevo.setText("")
        icon1 = QtGui.QIcon()
        icon1.addPixmap(QtGui.QPixmap("plus.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.buttonNuevo.setIcon(icon1)
        self.buttonNuevo.setIconSize(QtCore.QSize(61, 47))
        self.buttonNuevo.setObjectName("buttonNuevo")
        self.listNuevo = QtWidgets.QListView(self.centralwidget)
        self.listNuevo.setGeometry(QtCore.QRect(20, 140, 181, 401))
        self.listNuevo.setObjectName("listNuevo")
        self.listNuevo.setModel(modeloNuevos)
        self.listNuevo.clicked.connect(self.editar(nombre,i[0]))
        for i in self.nuevos(nombre):
            item = QtGui.QStandardItem(i[0])
            modeloNuevos.appendRow(item)
        self.listCalificado = QtWidgets.QListView(self.centralwidget)
        self.listCalificado.setGeometry(QtCore.QRect(240, 140, 181, 401))
        self.listCalificado.setObjectName("listCalificado")
        self.listCalificado.setModel(modeloCalificados)
        for i in self.calificados(nombre):
            item = QtGui.QStandardItem(i[0])
            modeloCalificados.appendRow(item)
        self.listPropuesta = QtWidgets.QListView(self.centralwidget)
        self.listPropuesta.setGeometry(QtCore.QRect(460, 140, 181, 401))
        self.listPropuesta.setObjectName("listPropuesta")
        self.listPropuesta.setModel(modeloPropuestas)
        for i in self.propuestas(nombre):
            item = QtGui.QStandardItem(i[0])
            modeloPropuestas.appendRow(item)
        self.listGanado = QtWidgets.QListView(self.centralwidget)
        self.listGanado.setGeometry(QtCore.QRect(680, 140, 181, 401))
        self.listGanado.setObjectName("listGanado")
        self.listGanado.setModel(modeloGanados)
        for i in self.ganados(nombre):
            item= QtGui.QStandardItem(i[0])
            modeloGanados.appendRow(item)
        self.labelNuevo = QtWidgets.QLabel(self.centralwidget)
        self.labelNuevo.setGeometry(QtCore.QRect(20, 100, 61, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(14)
        self.labelNuevo.setFont(font)
        self.labelNuevo.setObjectName("labelNuevo")
        self.labelCalificado = QtWidgets.QLabel(self.centralwidget)
        self.labelCalificado.setGeometry(QtCore.QRect(240, 100, 81, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(14)
        self.labelCalificado.setFont(font)
        self.labelCalificado.setObjectName("labelCalificado")
        self.labelPropuesta = QtWidgets.QLabel(self.centralwidget)
        self.labelPropuesta.setGeometry(QtCore.QRect(460, 100, 91, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(14)
        self.labelPropuesta.setFont(font)
        self.labelPropuesta.setObjectName("labelPropuesta")
        self.labelGanado = QtWidgets.QLabel(self.centralwidget)
        self.labelGanado.setGeometry(QtCore.QRect(680, 100, 61, 31))
        font = QtGui.QFont()
        font.setFamily("Impact")
        font.setPointSize(14)
        self.labelGanado.setFont(font)
        self.labelGanado.setObjectName("labelGanado")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 882, 21))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.labelPipeline.setText(_translate("MainWindow", "Pipeline"))
        self.labelNuevo.setText(_translate("MainWindow", "Nuevo"))
        self.labelCalificado.setText(_translate("MainWindow", "Calificado"))
        self.labelPropuesta.setText(_translate("MainWindow", "Propuesta"))
        self.labelGanado.setText(_translate("MainWindow", "Ganado"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_Pipeline()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())
