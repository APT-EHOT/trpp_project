package ru.kalumbas.partyhouse.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.core.extensions.jsonBody
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.kalumbas.partyhouse.R
import ru.kalumbas.partyhouse.Repository
import ru.kalumbas.partyhouse.activity.MainActivity
import ru.kalumbas.partyhouse.request.LoginRequest
import ru.kalumbas.partyhouse.response.LoginResponse

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        login = view.findViewById(R.id.loginEditText)
        password = view.findViewById(R.id.passwordEditText)
        loginButton = view.findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            if (login.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_LONG).show()
            } else {
                val response = getResponse(LoginRequest(login.text.toString(), password.text.toString()))
                if (response.success) {
                    Repository.sessionKey = response.sessionKey!!
                    startActivity(Intent(context, MainActivity::class.java))
                } else {
                    Toast.makeText(context, "Авторизация не удалась", Toast.LENGTH_LONG).show()
                }
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun getResponse(request: LoginRequest): LoginResponse {
        var a = ""
        Fuel.post(Repository.url + "/user/login")
            .header(Headers.CONTENT_TYPE, "application/json")
            .jsonBody(Json.encodeToString(request))
            .also { println(it) }
            .responseString { result -> a = result.component1().toString() }

        while (true) {
            try {
                Json.decodeFromString<LoginResponse>(a)
                break
            } catch (e: Exception) {

            }
        }

        return Json.decodeFromString(a)
    }
}