
package com.hi_depok.hi_depok.Kadepok_Volunteer;

        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.os.Build;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.WindowManager;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.PopupWindow;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.hi_depok.hi_depok.Activity_Main.BaseActivity;
        import com.hi_depok.hi_depok.Activity_Main.kadepok;
        import com.hi_depok.hi_depok.R;

        import static java.security.AccessController.getContext;

public class kadepok_volunteer_form extends BaseActivity {
    public Button btn_volunteer;
    private Spinner jenis_volunteer_spinner;
    private PopupWindow popupWindow;
    public Button close;

    private static final String[]jenis = {"Jenis Volunteer", "Guru Matematika", "Guru Fisika", "Guru Bahasa Inggris", "Guru Bahasa Indonesia"};

    public void verify_volunteer() {
        try {

            LayoutInflater layoutInflater = (LayoutInflater)kadepok_volunteer_form.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = layoutInflater.inflate(R.layout.kadepok_donasi_popup, (ViewGroup)findViewById(R.id.rl_custom_layout));

            popupWindow = new PopupWindow(layout, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
            popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

            close = (Button)layout.findViewById(R.id.close);
            close.setOnClickListener(cancel_button_click_listener);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
            Intent verify = new Intent(kadepok_volunteer_form.this, kadepok.class);
            startActivity(verify);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kadepok_volunteer_form);
<<<<<<< HEAD
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
=======
        super.onCreateDrawer();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
>>>>>>> origin/master
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_volunteer = (Button)findViewById(R.id.btn_volunteer);
        btn_volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify_volunteer();
            }
        });

        /*-------------------------- START SPINER CATEGORY --------------------------------------- */
        jenis_volunteer_spinner = (Spinner)findViewById(R.id.jenis_volunter_spinner);
        ArrayAdapter<String> adapter_camat = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,jenis);

        adapter_camat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenis_volunteer_spinner.setAdapter(adapter_camat);
        jenis_volunteer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        Toast.makeText(getApplicationContext(), ("Anda telah memilih Guru Matematika"),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), ("Anda telah memilih Guru Fisika"),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), ("Anda telah memilih Guru Bahasa Inggris"),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), ("Anda telah memilih Guru Bahasa Indonesia"),
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //NULL
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                kadepok_volunteer_form.this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

