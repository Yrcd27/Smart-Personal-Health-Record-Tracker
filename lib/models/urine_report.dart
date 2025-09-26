class UrineReport {
  final int id;
  final int userId;
  final DateTime testDate;
  final String color;
  final String appearance;
  final String protein;
  final String sugar;
  final double specificGravity;
  final String? imageUrl;

  UrineReport({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.color,
    required this.appearance,
    required this.protein,
    required this.sugar,
    required this.specificGravity,
    this.imageUrl,
  });

  // Factory constructor to create a UrineReport instance from a map (JSON)
  factory UrineReport.fromJson(Map<String, dynamic> json) {
    return UrineReport(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      color: json['color'] as String,
      appearance: json['appearance'] as String,
      protein: json['protein'] as String,
      sugar: json['sugar'] as String,
      specificGravity: json['specific_gravity'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert a UrineReport instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'color': color,
      'appearance': appearance,
      'protein': protein,
      'sugar': sugar,
      'specific_gravity': specificGravity,
      'image_url': imageUrl,
    };
  }
}