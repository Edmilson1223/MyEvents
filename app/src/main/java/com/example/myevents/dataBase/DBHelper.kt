package com.example.myevents.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "database.db", null, 1) {

    // Um array de strings com os comandos SQL para criar as tabelas
    val sql = arrayOf(
        "CREATE TABLE Promotor (promotor_id INTEGER PRIMARY KEY AUTOINCREMENT, nome_promotor TEXT, cni TEXT, nif VARCHAR, email TEXT, password TEXT, nib TEXT)",
        "INSERT INTO Promotor (nome_promotor, cni, nif, email, password, nib) VALUES ('João Silva', '123456789', '342672589', 'joao@exemplo.com', 'senha123', '12345678901234567890')",
        "INSERT INTO Promotor (nome_promotor, cni, nif, email, password, nib) VALUES ('Pedro Cardoso', '123987654', '243578901', 'pedro@exemplo.com', 'senha321', '12345678910111213141')",

        "CREATE TABLE Evento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome_evento TEXT, data_hora TIMESTAMP, local TEXT, descricao TEXT, id_promotor INTEGER, FOREIGN KEY (id_promotor) REFERENCES Promotor (promotor_id))",
        "INSERT INTO Evento(nome_evento, data_hora, local, descricao, id_promotor) VALUES('Show de Rock', '2024-02-10 22:00:00', 'Arena Rock', 'Não perca o show da banda Rock Star!', 2)",
        "INSERT INTO Evento(nome_evento, data_hora, local, descricao, id_promotor) VALUES('Festa de Aniversário', '2024-01-30 20:00:00', 'Salão de Festas', 'Venha comemorar o aniversário do João!', 1)",

        "CREATE TABLE Cliente (cliente_id INTEGER PRIMARY KEY AUTOINCREMENT, nome_cliente TEXT, username TEXT, password TEXT)",
        "INSERT INTO Cliente(nome_cliente, username, password) VALUES('Pedro', 'pedro456', 'senha456')",
        "INSERT INTO Cliente(nome_cliente, username, password) VALUES('Maria', 'maria123', 'senha123')",

        "CREATE TABLE Bilhete (id INTEGER PRIMARY KEY AUTOINCREMENT, preco REAL, quantidade INTEGER, total REAL, id_evento INTEGER, id_cliente INTEGER, FOREIGN KEY (id_evento) REFERENCES Evento (id), FOREIGN KEY (id_cliente) REFERENCES Cliente (cliente_id))",
        "INSERT INTO Bilhete(preco, quantidade, total, id_evento, id_cliente) VALUES(10.0, 2, 20.0, 100, 50)",
        "INSERT INTO Bilhete(preco, quantidade, total, id_evento, id_cliente) VALUES(15.0, 1, 15.0, 101, 51)"

        )

    override fun onCreate(db: SQLiteDatabase) {
        // Executa cada comando SQL do array
        sql.forEach {
            db.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Apaga as tabelas existentes e recria-as
        db.execSQL("DROP TABLE Promotor")
        db.execSQL("DROP TABLE Evento")
        db.execSQL("DROP TABLE Cliente")
        db.execSQL("DROP TABLE Bilhete")
        onCreate(db)
    }

    // Um método genérico para inserir dados em qualquer tabela
    fun insert(tableName: String, values: ContentValues): Long {
        val db = this.writableDatabase // Conexão de escrita à base de dados
        val res = db.insert(tableName, null, values) // Insere os valores na tabela
        db.close() // Fecha a conexão
        return res // Retorna o resultado da operação
    }

    // Um método genérico para atualizar dados em qualquer tabela
    fun update(tableName: String, values: ContentValues, id: Int): Int {
        val db = this.writableDatabase // Conexão de escrita à base de dados
        val res = db.update(tableName, values, "id=?", arrayOf(id.toString())) // Atualiza os valores na tabela onde o id é igual ao id passado como parâmetro
        db.close() // Fecha a conexão
        return res // Retorna o resultado da operação
    }

    // Um método genérico para apagar dados em qualquer tabela
    fun delete(tableName: String, id: Int): Int {
        val db = this.writableDatabase // Conexão de escrita à base de dados
        val res = db.delete(tableName, "id=?", arrayOf(id.toString())) // Apaga os dados na tabela onde o id é igual ao id passado como parâmetro
        db.close() // Fecha a conexão
        return res // Retorna o resultado da operação
    }

    // Um método genérico para selecionar todos os dados de qualquer tabela
    fun selectAll(tableName: String): Cursor {
        val db = this.readableDatabase // Conexão de leitura à base de dados
        val c = db.rawQuery("SELECT * FROM $tableName", null) // Executa uma consulta SQL para selecionar todos os dados da tabela
        db.close() // Fecha a conexão
        return c // Retorna o cursor com os dados
    }

    // Um método genérico para selecionar um dado específico de qualquer tabela pelo id
    fun selectById(tableName: String, id: Int): Cursor {
        val db = this.readableDatabase // Conexão de leitura à base de dados
        val c = db.rawQuery("SELECT * FROM $tableName WHERE id=?", arrayOf(id.toString())) // Executa uma consulta SQL para selecionar o dado da tabela onde o id é igual ao id passado como parâmetro
        db.close() // Fecha a conexão
        return c // Retorna o cursor com o dado
    }
    fun checkUserLogin(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM Promotor WHERE email = '$email' AND password = '$password'"
        val cursor = db.rawQuery(query, null)
        val result = cursor.count > 0
        cursor.close()
        db.close()
        return result
    }
    fun checkClienteLogin(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT email, password FROM Promotor WHERE email = '$email' AND password = '$password' UNION SELECT username, password FROM Cliente WHERE username = '$email' AND password = '$password'"
        val cursor = db.rawQuery(query, null)
        val result = cursor.count > 0
        cursor.close()
        db.close()
        return result
    }



}