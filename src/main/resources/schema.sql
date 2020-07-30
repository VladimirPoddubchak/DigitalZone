create table page_visit (
  id IDENTITY primary key,
  user_id LONG,
  page_id LONG,
  visit_date DATE
);