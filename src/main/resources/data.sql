-- 商品カテゴリの初期データ
INSERT INTO m_goods_category (
    goods_category_id,
    goods_category_name
) VALUES
(
    1,
    '就職活動'
),
(
    2,
    '資格試験'
),
(
    3,
    '仕事術'
),
(
    4,
    '趣味娯楽'
);

-- 商品の初期データ
INSERT INTO m_goods (
    goods_id,
    goods_name,
    goods_description,
    goods_category_id,
    price
) VALUES
(
    '0001',
    '必勝面接',
    '面接のポイントを実演を通じて説明します。',
    1,
    100
),
(
    '0002',
    'はじめての日商簿記3級',
    '初学者向けに簿記の入門および日商簿記試験3級合格に必要な知識を解説します。',
    2,
    200
),
(
    '0003',
    'できるビジネスパーソンのプレゼンテーション',
    'ビジネスマンの必須スキルであるプレゼンテーション能力。資料作成から発表のノウハウを伝授します。',
    3,
    400
),
(
    '0004',
    '動画でわかるITパスポート試験',
    'IT系国家試験の入門であるITパスポート試験を動画で解説します。',
    2,
    800
);

-- 職業の初期データ
INSERT INTO m_occupation (
    occupation_id,
    occupation_name
) VALUES (
    1,
    '学生'
),
(
    2,
    '会社員'
),
(
    3,
    '公務員'
),
(
    4,
    'その他'
);

-- ユーザーの初期データ
INSERT INTO m_user (
    user_id,
    password,
    user_name,
    furigana,
    phone_number,
    birthday,
    occupation_id,
    role
) VALUES (
    'user@co.jp',
    'password',
    '教材太郎',
    'キョウザイタロウ',
    '0123456789',
    '2000-01-01',
    2,
    'ROLE_GENERAL'
),
(
    'system@co.jp',
    'password',
    'システム管理者',
    'キョウザイカンリシャ',
    '0123456789',
    '2000-01-01',
    4,
    'ROLE_ADMIN'
);

-- 支払方法の初期データ
INSERT INTO m_payment_method (
    payment_method_id,
    payment_method_name
) VALUES (
    0,
    'デモ用決済'
),
(
    1,
    'クレジットカード決済'
),
(
    2,
    'キャリア決済'
),
(
    3,
    '後払い'
),
(
    4,
    'コンビニ決済(web)'
),
(
    5,
    'ID決済'
);