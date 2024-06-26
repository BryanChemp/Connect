package br.com.example.connect.statics

import br.com.example.connect.type.Doubt

class DoubtList {
    companion object {
        val doubts: List<Doubt> = listOf(
            Doubt("Não consigo lembrar minha senha. Como posso recuperá-la?", "Você pode recuperar sua senha clicando no link 'Esqueci minha senha' na página de login e seguindo as instruções enviadas para seu e-mail."),
            Doubt("Recebo uma mensagem de erro 'usuário ou senha inválidos'. O que devo fazer?", "Verifique se você digitou corretamente seu nome de usuário e senha. Se o problema persistir, tente redefinir sua senha."),
            Doubt("Como posso recuperar meu nome de usuário?", "Você pode recuperar seu nome de usuário clicando no link 'Esqueci meu nome de usuário' na página de login e seguindo as instruções enviadas para seu e-mail."),
            Doubt("Registrei-me, mas não recebi o e-mail de confirmação. O que fazer?", "Verifique sua pasta de spam ou lixo eletrônico. Se não encontrar o e-mail de confirmação, solicite o reenvio ou entre em contato com o suporte."),
            Doubt("Tentei criar uma conta, mas recebo uma mensagem de que a conta já existe. Como resolver?", "Isso pode ocorrer se você já tiver uma conta com o mesmo e-mail. Tente recuperar sua senha ou use um e-mail diferente para criar uma nova conta."),
            Doubt("Como posso alterar o endereço de e-mail associado à minha conta?", "Acesse as configurações da sua conta e procure a opção de alterar o e-mail. Siga as instruções fornecidas."),
            Doubt("Não estou conseguindo redefinir minha senha. O link de redefinição não funciona.", "Certifique-se de que você está usando o link mais recente enviado para seu e-mail. Se ainda assim não funcionar, solicite um novo link de redefinição."),
            Doubt("Comecei o cadastro, mas não consegui concluir. Como posso completar meu cadastro?", "Acesse novamente a página de cadastro e insira as informações necessárias. Se houver problemas, entre em contato com o suporte para assistência.")
        )
    }
}