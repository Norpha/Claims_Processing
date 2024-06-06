package com.jemutai.equityinsuranceapplication.data





object Home : ObjectScreen{
    override val title: String = "home"
    override val route: String = "home"

}
object SplashObject : ObjectScreen{
    override val title: String = "splash"
    override val route: String = "splash"

}
object PoliciesStatusObject : ObjectScreen{

    override val title: String = "policies"
    override val route: String = "policies"
}

object ClaimObject : ObjectScreen{

    override val title: String = "claim"
    override val route: String = "claim"
}


interface ObjectScreen {
    val title: String
    val route: String
}
