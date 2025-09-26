class Reports {
  final int id;
  final int userId;
  final int? fbcId;
  final int? liverId;
  final int? urineId;
  final int? fbsId;
  final int? lipidId;
  final int? bpId;
  final DateTime reportDate;
  final String summary;
  final String? imageUrl;

  Reports({
    required this.id,
    required this.userId,
    this.fbcId,
    this.liverId,
    this.urineId,
    this.fbsId,
    this.lipidId,
    this.bpId,
    required this.reportDate,
    required this.summary,
    this.imageUrl,
  });

  // Factory constructor to create a Reports instance from a map (JSON)
  factory Reports.fromJson(Map<String, dynamic> json) {
    return Reports(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      fbcId: json['fbc_id'] as int?,
      liverId: json['liver_id'] as int?,
      urineId: json['urine_id'] as int?,
      fbsId: json['fbs_id'] as int?,
      lipidId: json['lipid_id'] as int?,
      bpId: json['bp_id'] as int?,
      reportDate: DateTime.parse(json['report_date'] as String),
      summary: json['summary'] as String,
      imageUrl: json['image_url'] as String?,
    );
  }

  // Method to convert a Reports instance to a map (JSON)
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'user_id': userId,
      'fbc_id': fbcId,
      'liver_id': liverId,
      'urine_id': urineId,
      'fbs_id': fbsId,
      'lipid_id': lipidId,
      'bp_id': bpId,
      'report_date': reportDate.toIso8601String(),
      'summary': summary,
      'image_url': imageUrl,
    };
  }
}