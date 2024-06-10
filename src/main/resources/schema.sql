-- 商品マスタのPKのためのシーケンス
CREATE SEQUENCE IF NOT EXISTS goods_seq;

-- ユーザーのPKのためのシーケンス
CREATE SEQUENCE IF NOT EXISTS user_seq;

-- 商品購入履歴のPKのためのシーケンス
CREATE SEQUENCE IF NOT EXISTS goods_purchase_history_seq;

-- 商品マスタ
CREATE TABLE IF NOT EXISTS m_goods (
    goods_id INT PRIMARY KEY,
    goods_name VARCHAR(50),
    goods_description VARCHAR(200),
    goods_category_id INT,    
    price INT,
    service_url VARCHAR(200)
);

-- 商品カテゴリマスタ
CREATE TABLE IF NOT EXISTS m_goods_category (
    goods_category_id INT PRIMARY KEY,
    goods_category_name VARCHAR(50)    
);

-- ユーザー
CREATE TABLE IF NOT EXISTS m_user (
    user_id INT PRIMARY KEY,
    mail_address VARCHAR(100),
    password VARCHAR(100),
    user_name VARCHAR(50),
    furigana VARCHAR(50),
    phone_number VARCHAR(20),
    birthday DATE,
    occupation_id INT,
    role VARCHAR(50)
);

-- 職業マスタ
CREATE TABLE IF NOT EXISTS m_occupation (
    occupation_id INT PRIMARY KEY,
    occupation_name VARCHAR(50)
);

-- 支払方法マスタ
CREATE TABLE IF NOT EXISTS m_payment_method (
    payment_method_id INT PRIMARY KEY,
    payment_method_name VARCHAR(50)
);

-- 商品購入履歴
CREATE TABLE IF NOT EXISTS t_goods_purchase_history (
    goods_purchase_history_id INT PRIMARY KEY,
    goods_id INT,
    user_id INT,
    purchase_date DATE,
    payment_method_id INT,
    FOREIGN KEY (goods_id) REFERENCES m_goods(goods_id),
    FOREIGN KEY (user_id) REFERENCES m_user(user_id),
    FOREIGN KEY (payment_method_id) REFERENCES m_payment_method(payment_method_id)
);

ALTER TABLE m_goods ADD FOREIGN KEY (goods_category_id) REFERENCES m_goods_category(goods_category_id);
ALTER TABLE m_user ADD FOREIGN KEY (occupation_id) REFERENCES m_occupation(occupation_id);