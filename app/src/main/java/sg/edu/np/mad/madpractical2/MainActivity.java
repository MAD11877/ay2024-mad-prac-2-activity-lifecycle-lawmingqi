package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sg.edu.np.mad.practical2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize a new User obj
        User user = new User("John Doe","MAD Developer",1,false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.helloworld);
        TextView tvDescription = findViewById(R.id.description);
        Button btnFollow = findViewById(R.id.follow);

        // Set the TextViews with the User's Name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText(user.followed ? "UNFOLLOW" : "FOLLOW");

        btnFollow.setOnClickListener(v -> {
            user.followed = !user.followed;
            // Update the text of the button
            btnFollow.setText(user.followed ? "UNFOLLOW" : "FOLLOW");

        });
    }
}