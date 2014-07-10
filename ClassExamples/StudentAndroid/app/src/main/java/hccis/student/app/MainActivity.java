package hccis.student.app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import business.Student;
import util.NetworkXML;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button buttonGetInfo;
    private TextView textViewStudentInfo;
    private EditText editTextStudentId;
    private ProgressDialog pDialog;
    public static String xmlStudentInfo;
    @Override
    public void onClick(View v) {

        //will do something here...
//        textViewStudentInfo.setText("This is the info for studentId="+editTextStudentId.getText());


        // Loading announcements in Background Thread
        new GetStudentInfo().execute();
//        textViewStudentInfo.setText(NetworkXML.makeHttpRequestXML(""));
        editTextStudentId.setText("");


    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGetInfo = (Button) findViewById(R.id.buttonGetStudent);
        textViewStudentInfo = (TextView) findViewById(R.id.textViewStudentInfo);
        editTextStudentId = (EditText) findViewById(R.id.editTextStudentId);
        buttonGetInfo.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class GetStudentInfo extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        private String xml;

         @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All announcements from url
         * */
        protected String doInBackground(String... args) {

           xml = NetworkXML.makeHttpRequestXML("http://bjmac.hccis.info:8080/StudentTest/StudentInformationServlet?studentId="+editTextStudentId.getText().toString());

            // Log cat the JSON response
            Log.d("Student info: ", xml);

            return null;
        }

        /**
         * After completing the background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all announcements
            pDialog.dismiss();
            // updating User Interface from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
//Will want to export the Student project into a jar
//Convert the xml to a Student object
//use the toString to set the textView information.

Student student;
student = new Student();
student.loadFromXML(xml);
textViewStudentInfo.setText(student.toString());

                }
            });

        }

    }


}
