class LipidProfile {
  final int id;
  final int userId;
  final DateTime testDate;
  final double totalCholesterol;
  final double hdl;
  final double ldl;
  final double vldl;
  final double triglycerides;
  final String? imageUrl;

  LipidProfile({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.totalCholesterol,
    required this.hdl,
    required this.ldl,
    required this.vldl,
    required this.triglycerides,
    this.imageUrl,
  });

  // Factory constructor to create a LipidProfile instance from a map (JSON)
  factory LipidProfile.fromJson(Map<String, dynamic> json) {
    return LipidProfile(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      totalCholesterol: json['total_cholesterol'] as double,
      hdl: json['hdl'] as double,
      ldl: json['ldl'] as double,
      vldl: json['vldl'] as double,
      triglycerides: json['triglycerides'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert a LipidProfile instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'total_cholesterol': totalCholesterol,
      'hdl': hdl,
      'ldl': ldl,
      'vldl': vldl,
      'triglycerides': triglycerides,
      'image_url': imageUrl,
    };
  }
}