package com.example.ayusensei2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatbotActivity extends AppCompatActivity {
    private RecyclerView recyclerViewChat;
    private EditText editTextMessage;
    private ImageButton buttonSend;
    private ChatAdapter chatAdapter;
    private List<String> chatMessages;
    private backButtonFunction backButtonFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerViewChat = findViewById(R.id.recyclerView_chat);
        editTextMessage = findViewById(R.id.txtchatinput);
        buttonSend = findViewById(R.id.button_send);

        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessages);

        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChat.setAdapter(chatAdapter);

        // Initialize the back button function
        backButtonFunction = new backButtonFunction(this);

        // Button click listener to send a message
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    // Add message to the list
                    chatMessages.add(message);
                    // Notify adapter of the new item
                    chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                    // Scroll to the bottom to show the new message
                    recyclerViewChat.scrollToPosition(chatMessages.size() - 1);
                    // Clear the input field
                    editTextMessage.setText("");
                } else {
                    // Optionally show a message if the input is empty
                    Toast.makeText(ChatbotActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return backButtonFunction.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
