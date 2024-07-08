package br.com.example.connect.statics

import br.com.example.connect.R
import br.com.example.connect.type.User

class Users {

    companion object {

        val user1 : User = User(
            name = "Bryan Chemp",
            perfilPhoto = R.drawable.perfil2
        )

        val user2 : User = User(
            name = "Gaby Portini",
            perfilPhoto = R.drawable.perfil1
        )

        val user3 : User = User(
            name = "Pedro",
            perfilPhoto = R.drawable.ic_perfil
        )

        val user4 : User = User(
            name = "Jose Albuguerge Pereira",
            perfilPhoto = R.drawable.ic_perfil
        )


    }

}