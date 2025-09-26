class User {
  final int id;
  final String name;
  final String email;
  final String pwd;
  final DateTime dob;
  final String gender;

  User({
    required this.id,
    required this.name,
    required this.email,
    required this.pwd,
    required this.dob,
    required this.gender,
  });

  // Factory constructor to create a User instance from a map (JSON)
  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json['id'] as int,
      name: json['name'] as String,
      email: json['email'] as String,
      pwd: json['pwd'] as String,
      dob: DateTime.parse(json['dob'] as String),
      gender: json['gender'] as String,
    );
  }

  // Method to convert a User instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'email': email,
      'pwd': pwd,
      'dob': dob.toIso8601String(),
      'gender': gender,
    };
  }
}