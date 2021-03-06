package mtk.kelompok.util;



 


 

import java.util.ArrayList;

import java.util.List;

import mtk.kelompok.entity.Quiz;

 

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

 

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

 

/**

 * DBAdapter class untuk database

 * 



 * 

 */

public class DBAdapter1 extends SQLiteAssetHelper

{

    private static final String     DB_NAME                 = "db_quiz";

    private static final int        DB_VER                  = 1;

 

    public static final String      TABLE_SOAL              = "tb_soal1";

    public static final String      COL_SOAL_ID             = "_id";

    public static final String      COL_SOAL_SOAL           = "soal";

    public static final String      COL_SOAL_JAWABAN_A      = "jawaban_a";

    public static final String      COL_SOAL_JAWABAN_B      = "jawaban_b";

    public static final String      COL_SOAL_JAWABAN_C      = "jawaban_c";

    public static final String      COL_SOAL_JAWABAN_BENAR  = "jawaban_benar";

 

    private static DBAdapter1        dbInstance              = null;

    private static SQLiteDatabase   db;


    /**

     * private Constructor, untuk menggunakan kelas ini gunakan getInstance()

     * 

     * @param context

     */

    private DBAdapter1(Context context)

    {

        super(context, DB_NAME, null, DB_VER);

    }

 

    /**

     * Method Singleton dari class DBAdapter

     */

    public static DBAdapter1 getInstance(Context context)

    {
        if (dbInstance == null)

        {

            dbInstance = new DBAdapter1(context);

            db = dbInstance.getWritableDatabase();

        }

        return dbInstance;

    }

 

    @Override

    public synchronized void close()

    {

        super.close();

        if (dbInstance != null)

        {

            dbInstance.close();

        }

    }

 

    /**

     * Method untuk mengambil semua data soal

     * 

     * @return List<Quiz> listSoal

     */

    public List<Quiz> getAllSoal1()

    {

        List<Quiz> listSoal = new ArrayList<Quiz>();

 

        Cursor cursor = db.query(TABLE_SOAL, new String[]

        {

                COL_SOAL_ID,

                COL_SOAL_SOAL,

                COL_SOAL_JAWABAN_A,

                COL_SOAL_JAWABAN_B,

                COL_SOAL_JAWABAN_C,

                COL_SOAL_JAWABAN_BENAR

        }, null, null, null, null, null);

 

        if (cursor.moveToFirst())

        {

            do

            {

                Quiz quiz = new Quiz();

                quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));

                quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));

                quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));

                quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));

                quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));

                quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));

 

                listSoal.add(quiz);

            } while (cursor.moveToNext());

        }

 

        return listSoal;

 

    }

}

