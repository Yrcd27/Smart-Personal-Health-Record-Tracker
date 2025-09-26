class FBS {
  final int id;
  final int userId;
  final DateTime testDate;
  final double fbsLevel;
  final String? imageUrl;

  FBS({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.fbsLevel,
    this.imageUrl,
  });

  // Factory constructor to create an FBS instance from a map (JSON)
  factory FBS.fromJson(Map<String, dynamic> json) {
    return FBS(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      fbsLevel: json['fbs_level'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert an FBS instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'fbs_level': fbsLevel,
      'image_url': imageUrl,
    };
  }
}