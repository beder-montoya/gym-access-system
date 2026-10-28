# Gym Access System

Attendance and access control system for gyms: member management, memberships, payments, visit tracking, and (planned) fingerprint reader integration with automatic door control.

## Tech stack
- Backend: Java, Spring Boot, Spring Data JPA
- Frontend: Angular (coming soon)
- Database: MySQL 8 (Docker)

## Run locally
1. Copy `.env.example` to `.env`
2. `docker compose up -d`
3. Create `backend/src/main/resources/application-local.properties` with your DB credentials
4. Run `GymBackendApplication`

## Roadmap
- [ ] Members CRUD
- [ ] Memberships and payments
- [ ] Manual visit check-in
- [ ] Authentication and roles
- [ ] Angular UI and dashboard
- [ ] Fingerprint reader integration
- [ ] Automatic door control