package com.example.myevents

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "database.db", null, 1) {

    // Um array de strings com os comandos SQL para criar as tabelas
    val sql = arrayOf(
        "CREATE TABLE Promotor (id INTEGER PRIMARY KEY AUTOINCREMENT, nome_promotor TEXT, cni TEXT, nif VARCHAR, email TEXT, password TEXT, nib TEXT)",
        "INSERT INTO Promotor (nome_promotor, cni, nif, email, password, nib) VALUES ('João Silva', '123456789', '1234567890', 'joao@exemplo.com', 'senha123', '12345678901234567890')",
        "INSERT INTO Promotor (nome_promotor, cni, nif, email, password, nib) VALUES ('João Silva', '123456789', '1234567890', 'joao@exemplo.com', 'senha123', '12345678901234567890')",
        "CREATE TABLE Evento (id INTEGER PRIMARY KEY AUTOINCREMENT, nome_evento TEXT, data_hora TIMESTAMP, local TEXT, descricao TEXT, id_promotor INTEGER, FOREIGN KEY (id_promotor) REFERENCES Promotor (id))",
        "CREATE TABLE Cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome_cliente TEXT, username TEXT, password TEXT)",
        "CREATE TABLE Bilhete (id INTEGER PRIMARY KEY AUTOINCREMENT, preco REAL, quantidade INTEGER, total REAL, id_evento INTEGER, id_cliente INTEGER, FOREIGN KEY (id_evento) REFERENCES Evento (id), FOREIGN KEY (id_cliente) REFERENCES Cliente (id))"
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
}