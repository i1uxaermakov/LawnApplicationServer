<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String whichSectionIsActive = (String) request.getAttribute("ActiveNavBarSection");
    Boolean authorised = (Boolean) request.getSession().getAttribute("Authorised");
    if(Objects.isNull(authorised)) {
        authorised = false;
    }
%>

<header>
    <nav id="myNavbar" class="navbar navbar-default navbar-fixed-top  container-fluid" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/" style="padding-left: 12px; padding-top: 12px;"><img src="/logo/logo-green-wspace.png" height="23px"></a>
                <a class="myacc visible-xs" href="<%=(authorised)?"/acc":"/signin"%>">
                    <i class="fas fa-user-circle"></i>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="nav navbar-nav navbar-right container-fluid">
                    <%--<li class="">--%>
                        <%--<a data-toggle="tabs" href="index.html">--%>
                            <%--<i class="fas fa-home"></i>--%>
                            <%--Home</a>--%>
                    <%--</li>--%>
                    <li class="<%=("education".equals(whichSectionIsActive))?"active":""%>">
                        <a data-toggle="tabs" href="/edu/sc">
                            <i class="fas fa-graduation-cap"></i>
                            Education</a>
                    </li>
                    <%--<li class="">--%>
                        <%--<a data-toggle="tabs" href="community.html">--%>
                            <%--<i class="fas fa-users"></i>--%>
                            <%--Community</a>--%>
                    <%--</li>--%>
                    <%--<li class="">--%>
                        <%--<a data-toggle="tabs" href="album.html">--%>
                            <%--<i class="fas fa-images"></i>--%>
                            <%--Album</a>--%>
                    <%--</li>--%>
                    <li class="<%=("authorisation".equals(whichSectionIsActive))?"active":""%> hidden-xs">
                        <a data-toggle="tabs" href="<%=(authorised)?"/acc":"/signin"%>">
                            <i class="fas fa-user-circle"></i>
                            <%=(authorised)?"Account":"Sign In"%></a>
                    </li>
                    <li class="dropdown <%=("common".equals(whichSectionIsActive))?"active":""%>">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-cog"></i>
                            Settings
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/files/fav">Favorite Files</a></li>
                            <%--<li><a href="#">FAQ</a></li>--%>
                            <li><a href="/signout">Sign Out</a></li>
                            <%--<li><a href="#">My organizations</a></li>--%>
                            <%--<li><a href="#">Liked posts</a></li>--%>
                            <%--<li><a href="#">My posts</a></li>--%>
                            <%--<li><a href="#">Tickets</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>