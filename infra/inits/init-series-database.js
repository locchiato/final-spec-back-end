db = db.getSiblingDB("series_database");

db.createUser({
    user: "superuser",
    pwd: "superuser",
    roles: [
        {
            role: "dbOwner",
            db: "series_database"
        }
    ],
});

db.createUser({
    user: "series",
    pwd: "series",
    roles: [
        {
            role: "readWrite",
            db: "series_database"
        }
    ],
});
