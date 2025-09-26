class BloodPressure {
  final int id;
  final int userId;
  final DateTime testDate;
  final double bpLevel;
  final String? imageUrl;

  BloodPressure({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.bpLevel,
    this.imageUrl,
  });

  // Factory constructor to create a BloodPressure instance from a map (JSON)
  factory BloodPressure.fromJson(Map<String, dynamic> json) {
    return BloodPressure(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      bpLevel: json['bp_level'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert a BloodPressure instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'bp_level': bpLevel,
      'image_url': imageUrl,
    };
  }
}