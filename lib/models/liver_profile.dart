class LiverProfile {
  final int id;
  final int userId;
  final DateTime testDate;
  final double proteinTotalSerum;
  final double albuminSerum;
  final double bilirubinTotalSerum;
  final double sgpt;
  final String? imageUrl;

  LiverProfile({
    required this.id,
    required this.userId,
    required this.testDate,
    required this.proteinTotalSerum,
    required this.albuminSerum,
    required this.bilirubinTotalSerum,
    required this.sgpt,
    this.imageUrl,
  });

  // Factory constructor to create a LiverProfile instance from a map (JSON)
  factory LiverProfile.fromJson(Map<String, dynamic> json) {
    return LiverProfile(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      testDate: DateTime.parse(json['test_date'] as String),
      proteinTotalSerum: json['protein_total_serum'] as double,
      albuminSerum: json['albumin_serum'] as double,
      bilirubinTotalSerum: json['bilirubin_total_serum'] as double,
      sgpt: json['sgpt'] as double,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert a LiverProfile instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'test_date': testDate.toIso8601String(),
      'protein_total_serum': proteinTotalSerum,
      'albumin_serum': albuminSerum,
      'bilirubin_total_serum': bilirubinTotalSerum,
      'sgpt': sgpt,
      'image_url': imageUrl,
    };
  }
}