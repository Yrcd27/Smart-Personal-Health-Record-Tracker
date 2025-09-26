class FBC {
  final int id;
  final int userId;
  final DateTime testDate;
  final double haemoglobin;
  final double totalLeucocyteCount;
  final double plateletCount;
  final String? imageUrl;

  FBC({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.haemoglobin,
    required this.totalLeucocyteCount,
    required this.plateletCount,
    this.imageUrl,
  });

  // Factory constructor to create an FBC instance from a map (JSON)
  factory FBC.fromJson(Map<String, dynamic> json) {
    return FBC(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      haemoglobin: json['haemoglobin'] as double,
      totalLeucocyteCount: json['total_leucocyte_count'] as double,
      plateletCount: json['platelet_count'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert an FBC instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'haemoglobin': haemoglobin,
      'total_leucocyte_count': totalLeucocyteCount,
      'platelet_count': plateletCount,
      'image_url': imageUrl,
    };
  }
}