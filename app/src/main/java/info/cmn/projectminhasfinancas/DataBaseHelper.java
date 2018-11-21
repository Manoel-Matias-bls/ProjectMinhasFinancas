package info.cmn.projectminhasfinancas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    //TABLE Usuarios
    public static String TABLE_NAME = "Usuarios"; // nome da tabela do banco de dados
    public static String _ID = "id"; // campo ID
    // campos da tabela
    public static String COLUMN_NAME_LOGIN = "login";
    public static String COLUMN_NAME_SENHA = "senha";

    //TABLE Operação
    public static String TABLE_NAME_OP = "Operacao";
    public static String _ID_OP = "id";
    public static String COLUMN_NAME_TIPO_OP = "tipoOp";
    public static String COLUMN_NAME_VALOR = "valor";
    public static String COLUMN_NAME_DATA = "data";
    public static String COLUMN_NAME_DESCRICAO = "descricao";
    public static String COLUMN_NAME_CATEGORIA = "categoria";


    // SQL completa
    private static final String SQL_CREATE_USER =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_LOGIN + " TEXT," +
                    COLUMN_NAME_SENHA + " TEXT) ";

    private static final String SQL_CREATE_OPERACAO =
            "CREATE TABLE "+ TABLE_NAME_OP +" ("+
                    _ID_OP +" INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TIPO_OP +" TEXT," +
                    COLUMN_NAME_VALOR +" TEXT," +
                    COLUMN_NAME_DATA +" TEXT," +
                    COLUMN_NAME_DESCRICAO +" TEXT," +
                    COLUMN_NAME_CATEGORIA +" TEXT)";

    private static final String SQL_DELETE_ENTRIES1 =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES2 =
            "DROP TABLE IF EXISTS " + TABLE_NAME_OP;


    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "Banco.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Esse método só é executado a primeira vez que o app é instalado
    @Override
    public void onCreate(SQLiteDatabase _db) {
        // Executa a SQL que cria o banco de dados
        _db.execSQL(SQL_CREATE_USER);
        _db.execSQL(SQL_CREATE_OPERACAO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        _db.execSQL(SQL_DELETE_ENTRIES1);
        _db.execSQL(SQL_DELETE_ENTRIES2);
        onCreate(_db);
    }


}