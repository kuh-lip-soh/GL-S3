<html>

<head>
    <title>www.fayeh.com</title>
</head>

<body>
    <h1>Welcome to www.fayeh.com Website</h1>
    <p>Index page for fayeh.com</p>
    <?php echo "<h2>hola <b>", date('Y/m/d'), "</b></h2>"; ?>

    <?php
$servername = "192.168.2.4";
$username = "shmemos";
$password = "Tfou3lik";
$dbname = "sakila";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("La connexion a échoué : " . $conn->connect_error);
}

$sql = "SELECT * FROM actor";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Affichage des données
    while($row = $result->fetch_assoc()) {
        echo "ID: " . $row["actor_id"]. " - Prénom: " . $row["first_name"]. " - Nom: " . $row["last_name"]. " - Dernière mise à jour: " . $row["last_update"]. "<br>";
    }
} else {
    echo "Aucun résultat trouvé dans la table actor.";
}

$conn->close();
?>
</body>

</html>