package com.example.elderly_care

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.elderly_care.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupListeners()
    }
    
    private fun setupListeners() {
        // Sign In Button
        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            
            if (validateInput(email, password)) {
                performLogin(email, password)
            }
        }
        
        // Forgot Password
        binding.forgotPasswordText.setOnClickListener {
            Toast.makeText(this, "Password reset functionality coming soon", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to forgot password screen
        }
        
        // Sign Up
        binding.signUpText.setOnClickListener {
            Toast.makeText(this, "Sign up functionality coming soon", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to sign up screen
        }
    }
    
    private fun validateInput(email: String, password: String): Boolean {
        // Clear previous errors
        binding.emailInputLayout.error = null
        binding.passwordInputLayout.error = null
        
        // Validate email
        if (email.isEmpty()) {
            binding.emailInputLayout.error = getString(R.string.error_empty_email)
            binding.emailEditText.requestFocus()
            return false
        }
        
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailInputLayout.error = getString(R.string.error_invalid_email)
            binding.emailEditText.requestFocus()
            return false
        }
        
        // Validate password
        if (password.isEmpty()) {
            binding.passwordInputLayout.error = getString(R.string.error_empty_password)
            binding.passwordEditText.requestFocus()
            return false
        }
        
        if (password.length < 6) {
            binding.passwordInputLayout.error = getString(R.string.error_short_password)
            binding.passwordEditText.requestFocus()
            return false
        }
        
        return true
    }
    
    private fun performLogin(email: String, password: String) {
        // TODO: Implement Firebase Authentication
        // For now, just show a success message
        Toast.makeText(
            this,
            "${getString(R.string.login_success)}\nEmail: $email",
            Toast.LENGTH_LONG
        ).show()
        
        // TODO: Navigate to main dashboard
        // val intent = Intent(this, DashboardActivity::class.java)
        // startActivity(intent)
        // finish()
    }
}
